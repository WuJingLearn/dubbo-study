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
package org.apache.dubbo.demo;

import javax.validation.GroupSequence;
import javax.validation.constraints.Size;
import java.util.concurrent.CompletableFuture;

public interface DemoService {


    @interface SayHello{}
    String sayHello(@Size(max = 3,groups = SayHello.class) String name);


   // @GroupSequence(value = Update.class)
    interface Save{}

    interface Update{}

    String save(Student student);


    String update(Student student);


    String sayHi(Student student);

    String eat(@Size(max = 4) String name, @Size(max = 4) String male, String fox,Student student);

    default CompletableFuture<String> sayHelloAsync(String name) {
        return CompletableFuture.completedFuture(sayHello(name));
    }


}