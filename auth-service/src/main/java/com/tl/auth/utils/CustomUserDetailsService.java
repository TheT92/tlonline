package com.tl.auth.utils;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 你可以在这里从数据库或其他数据源加载用户
        // 这是一个示例，通常你会加载实际的用户数据
        System.out.println("Loading user: ----------------------------" + username); // 调试日志
        if ("user".equals(username)) {
            System.out.println(User.withUsername(username).toString());
            // return User
            //         .withUsername(username)
                    // .password("{noop}password")  // {noop}表示不使用加密密码
            return User.builder()
                .username(username)
                .password(passwordEncoder.encode("password"))  // Ensure the password is encoded
                .roles("USER")
                .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

