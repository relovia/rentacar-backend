package com.tobeto.rentacarProject.security;

import com.tobeto.rentacarProject.business.abstracts.UserService;
import com.tobeto.rentacarProject.core.enums.Role;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private static final String[] WHITE_LIST_URLS = {
            "/v1/api-docs",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html",
            "/api/auth/register",
            "/api/auth/login",
            "/api/brands/**",
            "/api/cars/**",
            "/api/fuels/**",
            "/api/models/**",
            "/api/transmissions/**",
            "/api/rentals/**",
            "/api/users/**",
            "/api/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(WHITE_LIST_URLS).permitAll()
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/register", "/api/auth/login", "/api/rentals/**", "/api/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/brands/**", "/api/cars/**", "/api/fuels/**", "/api/models/**", "/api/transmissions/**", "/api/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users/**", "/api/**").hasAuthority(Role.USER.name())
                        .requestMatchers(HttpMethod.PUT, "/api/users/**", "/api/**").hasAuthority(Role.USER.name())
                        .requestMatchers(HttpMethod.DELETE, "/api/brands/**", "/api/cars/**", "/api/creditCards/**", "/api/fuels/**", "/api/models/**", "api/rentals/**", "/api/transmissions/**", "/api/users/**", "/api/**").hasAuthority(Role.ADMIN.name())
                        .requestMatchers(HttpMethod.POST, "/api/brands/**", "/api/cars/**", "/api/fuels/**", "/api/models/**", "/api/transmissions/**", "/api/**").hasAuthority(Role.ADMIN.name())
                        .requestMatchers(HttpMethod.PUT, "/api/brands/**", "/api/cars/**", "/api/fuels/**", "/api/models/**", "/api/transmissions/**", "/api/**").hasAuthority(Role.ADMIN.name())
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
