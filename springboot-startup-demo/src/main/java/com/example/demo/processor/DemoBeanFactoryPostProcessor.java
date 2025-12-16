package com.example.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义BeanFactoryPostProcessor
 * 演示在Bean实例化之前对BeanDefinition的处理阶段
 */
@Component
public class DemoBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("[启动阶段4] ======== BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry被调用 ========");
        System.out.println("[启动阶段4] 当前已注册的BeanDefinition数量: " + registry.getBeanDefinitionCount());
        
        // 可以在此阶段动态注册新的BeanDefinition
        // 例如：registry.registerBeanDefinition(...);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("[启动阶段4] ======== BeanFactoryPostProcessor.postProcessBeanFactory被调用 ========");
        System.out.println("[启动阶段4] 当前BeanFactory中的BeanDefinition数量: " + beanFactory.getBeanDefinitionCount());
        
        // 获取所有BeanDefinition的名称
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("[启动阶段4] 部分BeanDefinition名称示例:");
        for (int i = 0; i < Math.min(3, beanDefinitionNames.length); i++) {
            String beanName = beanDefinitionNames[i];
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            System.out.println("  - " + beanName + " (类型: " + beanDefinition.getBeanClassName() + ")");
        }
    }
}
