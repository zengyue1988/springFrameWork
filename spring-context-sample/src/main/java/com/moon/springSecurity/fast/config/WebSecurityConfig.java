package com.moon.springSecurity.fast.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.moon.springSecurity.fast.authentication.UserAuthenticationProvider;
import com.moon.springSecurity.fast.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;
	
	boolean dynamicValidation = true;
	boolean customValidation = true;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/v1/login","/api/v1/pre/**").permitAll()   // request matched against /pre/** and /login are fully accessible
                .antMatchers("/api/v1/user/**").hasRole("USER")                     // request matched against /user/** require a user to be authenticated and must be associated to the USER role
                .anyRequest().authenticated()                                // other URL access must be validated
                .and()
            .formLogin()
            	.failureUrl("/api/v1/login-error")
                .loginPage("/api/v1/login.html")                                // form-based authentication is enabled with a custom login page and failure url
                .loginProcessingUrl("/login/form")                           // login page submit url
                .permitAll()
                .and()
                .csrf().disable()                                             // disable csrf validation for testing
            .logout()
            	.logoutSuccessUrl("/api/v1/logout")
                .permitAll();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		if (dynamicValidation) {
			if (customValidation) {
				auth.authenticationProvider(userAuthenticationProvider);
			} else {
		    	//auth.userDetailsService(userService);
		    	auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
			}
    	} else {
    		auth.inMemoryAuthentication()
    		    .withUser("admin").password("123456").roles("USER")
    		    .and()
    		    .withUser("test").password("test123").roles("ADMIN");
    	}
    }
    
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
