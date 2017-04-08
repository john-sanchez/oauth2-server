/**
 * 
 */
package io.johnsanchez.oauth2s.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.johnsanchez.oauth2s.service.AuthUserDetailsService;

/**
 * @author John
 *
 */
@Configuration
//@EnableWebSecurity
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthUserDetailsService authUserDetailsService; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authUserDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().ignoringAntMatchers("/oauth/**")
		.and()
			.requestMatchers()
				.antMatchers("/login**",
						"/oauth/**",
						"/logout")
		.and()
			.authorizeRequests()
				.antMatchers("/login**",
						"/oauth/token**",
						"/logout").permitAll()
				.anyRequest()
					.authenticated()
		.and()
			.formLogin()
				.loginPage("/login").permitAll()
		.and()
			.logout()
				.permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**", "/webjars/**");
	}
	
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
