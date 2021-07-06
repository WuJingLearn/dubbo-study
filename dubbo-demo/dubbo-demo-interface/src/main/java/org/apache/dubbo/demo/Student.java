package org.apache.dubbo.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Student implements Serializable {
    @Size(min = 1)
    private String name;

    @Size(max = 5, groups = {DemoService.Save.class})
    private String sex;

    @NotNull(groups = DemoService.Update.class)
    private String mail;

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
