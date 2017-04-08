package io.johnsanchez.oauth2s.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.anonymous().disable()
			.requestMatcher(
					new OrRequestMatcher(
							new AntPathRequestMatcher("/admin/**"),
							new AntPathRequestMatcher("/me")))
			.authorizeRequests().anyRequest().authenticated()
		.and()
			.exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
		;
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("resources");
		resources.tokenStore(new JdbcTokenStore(dataSource));
	}
}