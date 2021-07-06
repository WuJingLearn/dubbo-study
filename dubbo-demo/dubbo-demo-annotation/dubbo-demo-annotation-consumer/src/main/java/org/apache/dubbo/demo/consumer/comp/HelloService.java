package org.apache.dubbo.demo.consumer.comp;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.demo.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class HelloService {
    @DubboReference
    private DemoService demoService;

    @PostConstruct
    public void init(){
        System.out.println("HelloService中客户端对象: "+demoService);
    }

}
