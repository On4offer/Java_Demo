package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * SpringBoot启动流程演示主类
 * 展示SpringBoot应用从main方法到IOC容器初始化的完整过程
 */
@SpringBootApplication
public class SpringBootStartupDemoApplication {

    public static void main(String[] args) {
        System.out.println("[启动阶段1] ======== 开始SpringBoot应用启动流程 ========");
        System.out.println("[启动阶段1] main方法被调用，准备创建SpringApplication对象");

        // 1. 创建SpringApplication对象并运行
        // 这一步包含了：
        // - 根据classpath推断应用类型（Web/Servlet/普通应用）
        // - 加载初始化器（ApplicationContextInitializer）
        // - 加载监听器（ApplicationListener）
        System.out.println("[启动阶段1] 调用SpringApplication.run()方法");
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootStartupDemoApplication.class, args);

        System.out.println("[启动阶段7] ======== SpringBoot应用启动完成 ========");
        
        // 演示：输出容器中的一些Bean信息
        System.out.println("[验证] IOC容器初始化完成，包含" + context.getBeanDefinitionCount() + "个Bean定义");
        System.out.println("[验证] 容器中的部分Bean名称示例：");
        String[] beanNames = Arrays.copyOfRange(context.getBeanDefinitionNames(), 0, Math.min(5, context.getBeanDefinitionCount()));
        for (String beanName : beanNames) {
            System.out.println("  - " + beanName);
        }
    }
}
