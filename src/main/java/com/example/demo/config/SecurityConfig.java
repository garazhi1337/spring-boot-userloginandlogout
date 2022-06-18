package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private UserDetailsService userDetailsService;
	
	@Autowired
	public SecurityConfig(@Qualifier("userDetailsServiceImpl")UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
        .authorizeRequests()
        .antMatchers("/registration").permitAll()
        //.antMatchers(HttpMethod.GET, "/add").hasAuthority(Permission.READ.getPermission())
        //.antMatchers(HttpMethod.POST, "/add").hasAuthority(Permission.WRITE.getPermission())
        .antMatchers("/css/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/auth/login").permitAll()
        .defaultSuccessUrl("/auth/success")
        .and()
        .logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutSuccessUrl("/auth/login");
	}
	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.builder()
					.username("admin")
					.password(passwordEncoder().encode("admin"))
					.authorities(ERole.ADMIN.getAuthorities())
					.build()
				);
	}*/
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
