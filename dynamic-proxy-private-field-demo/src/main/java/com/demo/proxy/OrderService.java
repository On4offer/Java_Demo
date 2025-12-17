package com.demo.proxy;

/**
 * 订单服务类（含私有属性，用于CGLIB动态代理演示）
 * 注意：CGLIB不需要接口，可以直接代理类
 */
public class OrderService {
    // 私有属性1：订单号
    private String orderNo = "ORDER_001";
    
    // 私有属性2：订单金额
    private Double amount = 99.99;
    
    // 私有属性3：订单状态
    private String status = "待支付";
    
    // 公共方法
    public void processOrder() {
        System.out.println("【目标方法执行】OrderService.processOrder()");
        System.out.println("处理订单：" + orderNo + ", 金额：" + amount + ", 状态：" + status);
    }
    
    public String getOrderDetails() {
        return "订单详情：订单号=" + orderNo + ", 金额=" + amount + ", 状态=" + status;
    }
    
    // 提供getter方法用于对比验证
    public String getOrderNo() {
        return orderNo;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public String getStatus() {
        return status;
    }
}

