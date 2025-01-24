package DailtyEtu.DailtyEtu.auth;


import jakarta.servlet.Filter;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Getter
@Setter
@Data
@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final JWTService jwtService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfiguration(JWTService jwtService, UserDetailsService userDetailsService, AuthenticationProvider authenticationProvider) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.authenticationProvider = authenticationProvider;
    }

    // JWTTokenFilter Bean'ini burada ekliyoruz
    @Bean
    public JWTTokenFilter jwtAuthFilter() {
        return new JWTTokenFilter(jwtService, userDetailsService);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        DefaultSecurityFilterChain build = http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/*",
                                "/user/**", "/api/validate-token")
                        .permitAll()
                        .anyRequest().authenticated()
                ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
        return build;
    }

}
