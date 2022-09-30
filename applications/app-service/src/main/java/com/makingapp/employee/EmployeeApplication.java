package com.makingapp.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.makingapp.employee","com.makingapp.employee.*"}
)
@ConfigurationPropertiesScan(basePackages = {"com.makingapp.employee"
        , "com.makingapp.employee.*"})
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
        System.out.println("INIT APPLICATION");
    }

}
