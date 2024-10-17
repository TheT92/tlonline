package com.tl.auth.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // private final CustomUserDetailsService userDetailsService;

    // public SecurityConfig(CustomUserDetailsService userDetailsService) {
    //     this.userDetailsService = userDetailsService;
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.err.println("--------------------------------11111111111111111");
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        // 允许所有人访问 /public/** 路径
                        .requestMatchers("/public/**").permitAll()
                        // 其他所有请求都需要认证
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        // 自定义登录页面
                        .loginPage("/login")
                        // 允许所有人访问登录页面
                        .permitAll())
                // 启用基本认证
                .httpBasic(httpBasic -> new SecurityConfig());

        return http.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     // 定义并返回自定义的 UserDetailsService 实现
    //     return new CustomUserDetailsService(new BCryptPasswordEncoder());
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 返回密码编码器 Bean
        return new BCryptPasswordEncoder();
    }
    
}
