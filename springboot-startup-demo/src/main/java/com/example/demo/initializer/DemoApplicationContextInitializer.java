package com.example.demo.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 自定义ApplicationContextInitializer
 * 演示SpringBoot启动流程中Environment准备完成后，容器刷新前的初始化过程
 */
public class DemoApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("[启动阶段2] ======== ApplicationContextInitializer被调用 ========");
        
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // 可以在此阶段操作Environment，如添加属性源、修改配置等
        System.out.println("[启动阶段2] 当前应用环境: " + (environment.getActiveProfiles().length > 0 ? 
                String.join(", ", environment.getActiveProfiles()) : "default"));
        
        // 添加自定义属性
        environment.getSystemProperties().put("demo.initializer.executed", "true");
        System.out.println("[启动阶段2] 已向Environment添加自定义属性");
    }
}
