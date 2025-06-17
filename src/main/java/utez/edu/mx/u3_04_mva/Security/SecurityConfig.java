package utez.edu.mx.u3_04_mva.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/branches/**").hasRole("ADMIN")
                        .requestMatchers("/api/warehouses/**").authenticated()
                        .requestMatchers("/api/clients/**").authenticated()
                        .anyRequest().permitAll()
                )
                .csrf(csrf -> csrf.disable()) // ✅ Nueva forma de deshabilitar CSRF
                .httpBasic(Customizer.withDefaults()); // Autenticación básica para pruebas

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails client = User.withDefaultPasswordEncoder()
                .username("client")
                .password("client123")
                .roles("CLIENT")
                .build();

        return new InMemoryUserDetailsManager(admin, client);
    }
}
