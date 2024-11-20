package com.tl.gateway.component;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.tl.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;

public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config> {
    // 过滤器，用来过滤并验证jwt

    public static class Config {
        // 配置参数（如果需要）
    }

    public JwtAuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath();
            if (path.equals("/user/signup")) {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                return chain.filter(exchange);  // 不进行任何身份验证，直接通过
            }

            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            try {
                String token = authHeader.substring(7);
                JwtUtils.validateToken(token); // 自定义验证逻辑

                Claims claims = JwtUtils.validateToken(token);
                String userId = claims.getSubject();

                // 如果需要，将用户信息传递到下游服务
                exchange.getRequest()
                        .mutate()
                        .header("X-User-ID", userId)
                        .build();

            } catch (Exception e) {
                System.out.println(e + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }

}
