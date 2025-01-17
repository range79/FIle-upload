package com.range.Fileupload.Config;

import com.range.Fileupload.Service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;
    private final MYPasswordEncoder myPasswordEncoder;
    public SecurityConfig(MYPasswordEncoder myPasswordEncoder , UserDetailsServiceImpl userDetailsServiceIMpl) {
        this.myPasswordEncoder = myPasswordEncoder;
        this.userDetailsService = userDetailsServiceIMpl;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .formLogin(login->login.loginPage("/login").permitAll().usernameParameter("email")
                        .passwordParameter("password").defaultSuccessUrl("/index"))
                .authorizeHttpRequests(
                        authorizeRequests ->
                                authorizeRequests.requestMatchers("/register").permitAll()

                                        .requestMatchers("/forgot-password").permitAll()

                                        .anyRequest().authenticated()
                );
        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(myPasswordEncoder.getPasswordEncoder());
        return provider;
    }


}
