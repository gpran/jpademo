package com.crud.jpademo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests((requests) -> requests
                        .requestMatchers("/", "/login/**","/hello/**").permitAll()
                        .requestMatchers("/home/**").hasRole("ADMIN")
                        .requestMatchers("/create","/showAll","/showById","/delete","/update").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/login","/hello").permitAll()
                        .requestMatchers("/home").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin().loginProcessingUrl("/login").permitAll()
                .and()
                .formLogin((requests) -> requests
                        .loginPage("/login")
                        .permitAll()
                )

                .logout((logout) -> logout.permitAll());

        return http.build();
    }
*/


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
