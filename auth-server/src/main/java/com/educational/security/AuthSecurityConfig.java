package com.educational.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableWebSecurity
@Configuration
public class AuthSecurityConfig {
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {

        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();
        RequestMatcher endpointsMatcher = authorizationServerConfigurer.getEndpointsMatcher();
        http.securityMatcher(endpointsMatcher).authorizeHttpRequests((authorize) -> {
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)authorize.anyRequest()).authenticated();
        }).csrf((csrf) -> {
            csrf.ignoringRequestMatchers(new RequestMatcher[]{endpointsMatcher});
        }).apply(authorizationServerConfigurer);

        return http.formLogin(Customizer.withDefaults()).build();
    }

    // Apenas configurações adicionais caso eu queira, url que eu queira permitir ou recusar pra determinado
    // tipo de role.
    @Bean
    public SecurityFilterChain authFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz.anyRequest().authenticated());
        return http.formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    RegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder) {
        return new InMemoryRegisteredClientRepository();
    }
}
