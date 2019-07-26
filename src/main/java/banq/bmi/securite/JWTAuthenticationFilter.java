package banq.bmi.securite;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import banq.bmi.entities.Uitisateur;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter  extends UsernamePasswordAuthenticationFilter{
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
		// recupeler le username et le password
		Uitisateur utilisateur = null;
		try {
		utilisateur=new ObjectMapper().readValue(request.getInputStream(), Uitisateur.class);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("***************************");
		System.out.println("username :"+utilisateur.getUsername());
		System.out.println("password :"+utilisateur.getPassword());
		//System.out.println("role :"+utilisateur.getRoles());
		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						utilisateur.getUsername(),
						utilisateur.getPassword()
						)
				
				);

	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response , FilterChain chain,
			Authentication authResult) throws IOException, ServletException{
		User springUser=(User)authResult.getPrincipal();
		String jwtToken=Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SCRET)
				.claim("roles",springUser.getAuthorities())
				.compact();
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwtToken);
	}
	
}
