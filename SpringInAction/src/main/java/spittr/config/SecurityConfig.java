package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("user").password("user").roles("USER")
		.and()
		.withUser("admin").password("admin").roles("USER","ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.
		formLogin()
		.loginPage("/login")
		.and()
		.httpBasic()
		.realmName("Spittr")
		.and()
		.rememberMe()
		.tokenValiditySeconds(2000000)
		.key("spittrKey")
		.and()
		.authorizeRequests()
//		.antMatchers("/spitters/me").authenticated()
	//	.antMatchers(HttpMethod.POST,"/spittles").authenticated()
		//.antMatchers("/spittles").authenticated()
		.antMatchers("/spitters/*").anonymous()
		.anyRequest().permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/")
		;
	}

	
}
