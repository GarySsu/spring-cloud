package com.gary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient // Eureka Client
@EnableZuulProxy // Zuul Proxy
public class GatewayApplication {

    public static void main(String[] args){
        SpringApplication.run(GatewayApplication.class,args);
    }

}
