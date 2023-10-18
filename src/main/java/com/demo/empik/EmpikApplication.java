package com.demo.empik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.demo.empik.repository")
public class EmpikApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpikApplication.class, args);
    }

}
