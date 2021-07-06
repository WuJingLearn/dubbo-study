/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.demo.consumer.comp;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.demo.DemoService;

import org.apache.dubbo.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;

@Component("demoServiceComponent")
public class DemoServiceComponent implements DemoService {
    //当参数完全相同时，才相同
    @DubboReference()
    private DemoService demoService;

    @Autowired
    ApplicationContext  applicationContext;

    @DubboReference(validation = "false")
    private DemoService demoService2;

    @PostConstruct
    public void init(){
        System.out.println("DemoService中客户端对象1: "+demoService+"客户端对象二: "+demoService2);
    }
    //
    @Override
    public String sayHello(String name) {
        return demoService.sayHello(name);
    }

    @Override
    public String save(Student student) {
          return demoService.save(student);
    }

    @Override
    public String update(Student student) {
        return demoService.update(student);
    }

    @Override
    public String sayHi(Student student) {
        return demoService.sayHi(student);
    }

    @Override
    public String eat(String name, String male,String fox,Student student) {
        return demoService.eat(name,male,fox,student);
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        return null;
    }
}
