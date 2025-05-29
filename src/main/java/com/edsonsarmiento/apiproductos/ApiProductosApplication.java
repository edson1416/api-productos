package com.edsonsarmiento.apiproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiProductosApplication {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = encoder.encode("edson1416");
        System.out.println(pass);
        SpringApplication.run(ApiProductosApplication.class, args);
    }
}
