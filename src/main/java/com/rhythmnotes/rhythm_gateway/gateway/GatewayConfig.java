package com.rhythmnotes.rhythm_gateway.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${service.diaryBackend}")
    private String diaryUrl;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/rhythmnotes/all")
                        .uri(diaryUrl))
                .route(r -> r
                        .host("/rhythmnotes/add")
                        .uri(diaryUrl))
                .build();
    }

}
