package com.example.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义BeanPostProcessor
 * 演示Bean实例化过程中对Bean进行前后处理的阶段
 */
@Component
public class DemoBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 只对我们自己的组件进行打印，避免过多日志
        if (beanName.startsWith("demo") || beanName.equals("demoApplicationListener") || 
            beanName.equals("demoBeanFactoryPostProcessor")) {
            System.out.println("[启动阶段5] BeanPostProcessor.postProcessBeforeInitialization: " + beanName);
        }
        return bean; // 返回原始bean或包装后的bean
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 只对我们自己的组件进行打印，避免过多日志
        if (beanName.startsWith("demo") || beanName.equals("demoApplicationListener") || 
            beanName.equals("demoBeanFactoryPostProcessor")) {
            System.out.println("[启动阶段5] BeanPostProcessor.postProcessAfterInitialization: " + beanName);
        }
        return bean; // 返回原始bean或包装后的bean
    }
}
