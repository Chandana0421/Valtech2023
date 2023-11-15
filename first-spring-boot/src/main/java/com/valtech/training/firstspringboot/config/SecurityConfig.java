package com.valtech.training.firstspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.valtech.training.firstspringboot.components.Arithmetic;
import com.valtech.training.firstspringboot.components.ArithmeticImpl;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.components.SimpleInterestImpl;


@Configuration
public class SecurityConfig {

//	@Bean
//	public Arithmetic arithmetic() {
//		return new ArithmeticImpl();
//	}
//	
//	@Bean
//	public SimpleInterest simpleInterest(Arithmetic arithmetic) {
//		return new SimpleInterestImpl(arithmetic());
//	}

	// configure users
	//-------------------now defines in AuthServiveImpl ----------------------
//	@Bean
//	public UserDetailsManager userDetailManager() {
//		UserDetails scott = User.builder().username("scott").password("tiger123").roles("USER").build();
//		UserDetails admin = User.builder().username("admin").password("admin123").roles("ADMIN", "USER").build();
//		return new InMemoryUserDetailsManager(scott, admin);
//	}

	// because password can't be stored in db! it stores pw as plaintext and it gets
	// hashed
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance(); //no operations
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		// cross-site-forgery
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/user", "/orders/**","/changePassword").hasAnyRole("USER", "ADMIN")
				.antMatchers("/admin").hasRole("ADMIN").antMatchers("/anon", "/login", "/logout","/register").anonymous()
				.anyRequest().authenticated();
//		httpSecurity.httpBasic();
		httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/hello?name=Valtech").failureUrl("/login?error=true");
		return httpSecurity.build();
	}
	
}