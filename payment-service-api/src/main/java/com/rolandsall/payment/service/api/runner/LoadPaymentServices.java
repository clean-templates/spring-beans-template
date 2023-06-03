package com.rolandsall.payment.service.api.runner;

import com.rolandsall.my.custom.payement.MyCustomPaymentService;
import com.rolandsall.payment.library.IPayService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;

import java.util.List;


@Configuration
@AllArgsConstructor
@Slf4j

public class LoadPaymentServices {


    public static final String BASE_PACKAGE = "com.rolandsall.my.custom.payement";
    private ConfigurableApplicationContext context;
    private List<IPayService> payServiceList;

    @Bean
    public void loadCustomPaymentServices() throws Exception{
        log.info("checking for payment services to load");
        String resourcePattern = createResourcePatternResolver();
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
        Resource[] resources = resourcePatternResolver.getResources(resourcePattern);

        for (Resource resource : resources) {
            if (resource.isReadable()) {
                MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                String className = metadataReader.getClassMetadata().getClassName();
                Class<?> clazz = Class.forName(className);
                if (isAssignableToIPayService(clazz)) {
                    IPayService payService = (IPayService) clazz.getDeclaredConstructor().newInstance();
                    payServiceList.add(payService);
                }
            }
        }
    }

    private String createResourcePatternResolver() {
        return ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                resolveBasePackage() + "/**/*.class";
    }

    private String resolveBasePackage() {
        return ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(LoadPaymentServices.BASE_PACKAGE));
    }

    private boolean isAssignableToIPayService(Class<?> clazz) {
        return IPayService.class.isAssignableFrom(clazz) && !clazz.isInterface();
    }


    private void coupledTechnique() {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        MyCustomPaymentService customPaymentService = new MyCustomPaymentService();
        beanFactory.registerSingleton("customPaymentService", customPaymentService);
        payServiceList.add(customPaymentService);
    }

}
