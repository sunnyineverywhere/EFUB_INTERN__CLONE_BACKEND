package com.efub.twitter_clone.global.config;

import com.efub.twitter_clone.global.config.jwt.JwtAuthenticationFilter;
import com.efub.twitter_clone.global.config.jwt.JwtProvider;
import com.efub.twitter_clone.global.exception.jwt.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AppConfig {

	private final JwtProvider jwtProvider;
	private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		// configuration.addAllowedOrigin("https://lakku-lakku.netlify.app");
		configuration.addAllowedOrigin("http://localhost:3000");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.cors().configurationSource(corsConfigurationSource())
				.and()
					.httpBasic().disable()
					.csrf().disable()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
					.exceptionHandling()
					.authenticationEntryPoint(customAuthenticationEntryPoint)
				.and()
					.authorizeRequests()
					.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
					.antMatchers("/api/v1/**").permitAll()
					//.antMatchers("/api/v1/users/signup/**", "/api/v1/users/login", "/api/v1/users/re-issue", "/api/v1/users/sendemail").permitAll()
				.anyRequest().authenticated()
				.and()
				.addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
