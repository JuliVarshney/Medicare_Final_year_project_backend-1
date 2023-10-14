package com.mymovie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mymovie.config.AuthEntryPoint;
import com.mymovie.config.JwtAuthFilter;
import com.mymovie.entities.CustomUserDetails;
import com.mymovie.services.MyUserDetailsService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private AuthEntryPoint authEntryPoint;
	
	@Autowired
	private JwtAuthFilter jwtAuthFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors()
		.disable()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/movie/**").hasRole("ADMIN")
		.antMatchers("/screen/**").hasRole("ADMIN")
		.antMatchers("/book/**").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and().exceptionHandling().authenticationEntryPoint(authEntryPoint)
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		
	}

}
