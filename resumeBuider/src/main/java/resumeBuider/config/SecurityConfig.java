package resumeBuider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            // This line tells Security to look for a CORS configuration
            .cors(Customizer.withDefaults()) 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/resumes/**").permitAll()
                .requestMatchers("/api/login/**").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
