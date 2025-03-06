package com.AD.NotificationManagement.Configuration;

import com.AD.NotificationManagement.Service.NotificationService;
import com.AD.NotificationManagement.Service.NotificationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class NMConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/send").authenticated() // Protect specific endpoints
                        .anyRequest().permitAll()) // Everything else is public
                .httpBasic(); // Enable Basic Auth (suitable for APIs)

        return http.build();
    }


    @Bean
    public NotificationService getNotificationService(){
        return new NotificationServiceImpl();
   }


}
