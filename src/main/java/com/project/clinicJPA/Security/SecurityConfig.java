package com.project.clinicJPA.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails sam = User.builder()
                .username("sam")
                .password("{noop}123")
                .roles("USER")
                .build();
        UserDetails ahmed = User.builder()
                .username("ahmed")
                .password("{noop}123")
                .roles("USER","MANGER")
                .build();
        UserDetails mohamed = User.builder()
                .username("mohamed")
                .password("{noop}123")
                .roles("USER","MANGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(sam,ahmed,mohamed);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/doctor/list").hasRole("USER")
                .requestMatchers("/doctor/showFormForAdd").hasRole("MANGER")
                .requestMatchers("/doctor/showFormForUpdate").hasRole("MANGER")
                .requestMatchers("/patient/showFormForAdd").hasRole("MANGER")
                .requestMatchers("/patient/list").hasRole("USER")
                .requestMatchers("/patient/showFormForUpdate").hasRole("MANGER")
//                .requestMatchers(HttpMethod.POST,"/patient").hasRole("MANGER")
//                .requestMatchers(HttpMethod.PUT,"/patient").hasRole("MANGER")
//                .requestMatchers(HttpMethod.DELETE,"/patient/**").hasRole("ADMIN")
        );
        // http basic authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable CSRF
            http.csrf(csrf -> csrf.disable());

        return http.build();
    }


}
