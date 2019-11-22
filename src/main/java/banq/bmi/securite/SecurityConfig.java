package banq.bmi.securite;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import banq.bmi.securite.JWTAuthorizationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	 public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	 }
	 @Override
	 protected void configure(HttpSecurity http) throws Exception{
		 http.cors().and()
				 // starts authorizing configurations
				 .authorizeRequests()
				 // ignoring the guest's urls "
				 .antMatchers("register", "login", "/logout","/uploadFile").permitAll()
				 // authenticate all remaining URLS
				 .anyRequest().fullyAuthenticated().and()
				 /* "/logout" will log the user out by invalidating the HTTP Session,
				  * cleaning up any {link rememberMe()} authentication that was configured, */
				 .logout()
				 .permitAll()
				 .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
				 .and()
				 // enabling the basic authentication
				 .httpBasic().and()
				 // configuring the session on the server
				 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
				 // disabling the CSRF - Cross Site Request Forgery
				 .csrf().disable();
	 }
	// this configuration allow the client app to access the this api
	// all the domain that consume this api must be included in the allowed o'rings
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*").allowedOrigins("*").allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS");

			}
		};
	}

}
