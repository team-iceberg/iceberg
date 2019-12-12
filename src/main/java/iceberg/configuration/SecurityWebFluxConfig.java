package iceberg.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityWebFluxConfig {

    @Value("${security.authorized_origin}")
    private String authorizedOrigin;

    /**
     * Security web filter chain security web filter chain.
     *
     * @param http         the http
     * @return the security web filter chain
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return applyCommonHttpSecurity(http).build();
    }

    /**
     * Apply common http security server http security.
     *
     * @param http the http
     * @return the server http security
     */
    public static ServerHttpSecurity applyCommonHttpSecurity(ServerHttpSecurity http) {
        return http.authorizeExchange().pathMatchers("/**").permitAll().pathMatchers("/login").permitAll().pathMatchers("/identification")
                .permitAll().pathMatchers("/info").permitAll().pathMatchers("/health").permitAll().pathMatchers("/prometheus").permitAll()
                .pathMatchers("/swagger").permitAll().anyExchange().authenticated().and().exceptionHandling()
                .authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED)).and().httpBasic().disable().formLogin().disable()
                .csrf().disable().logout().disable();
    }

    @Bean
    CorsConfigurationSource corsConfiguration() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.applyPermitDefaultValues();

        corsConfig.addAllowedMethod(HttpMethod.POST);
        corsConfig.addAllowedMethod(HttpMethod.GET);
        corsConfig.addAllowedMethod(HttpMethod.PUT);
        corsConfig.addAllowedMethod(HttpMethod.DELETE);
        corsConfig.addAllowedMethod(HttpMethod.OPTIONS);
        corsConfig.addAllowedHeader(authorizedOrigin);
        corsConfig.setAllowedOrigins(Collections.singletonList(authorizedOrigin));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }
}
