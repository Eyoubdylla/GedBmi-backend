package banq.bmi.securite;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
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
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
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
		 http.csrf().disable();
		 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 // http.formLogin();
		 http.authorizeRequests().antMatchers("/login/**","/uitisateurs/**","listDossier/**","/listUser/**","/register/**","/listUser/update/{id}","/listUser/{id}").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.POST,"/dossier/**","listDossier/**","/uitisateurs/**","/listUser/**","/register/**").hasAuthority("ADMIN");
		 http.authorizeRequests().antMatchers(HttpMethod.GET,"/listUser/**","listDossier/**").hasAuthority("ADMIN");
		 http.authorizeRequests().anyRequest().authenticated();
		 http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		 http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	 }
}