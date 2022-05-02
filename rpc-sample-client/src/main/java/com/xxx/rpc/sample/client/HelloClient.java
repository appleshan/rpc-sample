package com.xxx.rpc.sample.client;

import com.xxx.rpc.client.RpcProxy;
import com.xxx.rpc.sample.api.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // 注入 RpcProxy 对象
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);

        // 调用 RpcProxy 对象的 create 方法来创建 RPC 代理接口
        HelloService helloService = rpcProxy.create(HelloService.class);

        // 调用 RPC 代理接口的方法，就像调用远程接口方法一样
        String result = helloService.hello("World");
        System.out.println(result);

        HelloService helloService2 = rpcProxy.create(HelloService.class, "sample.hello2");
        String result2 = helloService2.hello("世界");
        System.out.println(result2);

        System.exit(0);
    }
}
