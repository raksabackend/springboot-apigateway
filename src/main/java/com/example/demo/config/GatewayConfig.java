package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

       return builder.routes()
               .route("client1-orderservice", r -> r.path("/order/**")
                       .uri("lb://CLIENT1-ORDERSERVICE"))
               .route("client2-authservice", r -> r.path("/auth/**")
                       .uri("lb://CLIENT2-AUTHSERVICE")
               )
               .build();

    }

}
