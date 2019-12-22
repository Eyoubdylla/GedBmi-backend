package banq.bmi.securite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	    response.addHeader("Cross-Origin Request","*");
		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Headers",
//				"Origin , Accept , X-Requested-With, Content-Type, " +
//                        "Access-Control-Request-Method,"+
//				 "Access-Control-Request-Headers,"
//                +"Authorization");
		
		response.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin,"
				+ "Access-Contol-Allow-Credentials,Authorization");
		response.addHeader("Access-Control-Allow-Methods","GET,POST,DELETE, PUT, UPDATE, OPTIONS");

		if(request.getMethod().equals("OPTIONS")){
		    response.setStatus(HttpServletResponse.SC_OK);
        }else{
            String jwt=request.getHeader(SecurityConstants.HEADER_STRING);
            if(jwt==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
                filterChain.doFilter(request, response); return ;
            }
            Claims claim=Jwts.parser()
                    .setSigningKey(SecurityConstants.SCRET)
                    .parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getBody();
            String username=claim.getSubject();
            ArrayList<Map<String,String>> roles=(ArrayList<Map<String,String>>)claim.get("roles");
            Collection<GrantedAuthority> authorities=new ArrayList<>();
            roles.forEach(r->{
                authorities.add(new SimpleGrantedAuthority(r.get("authority")));
            });
            UsernamePasswordAuthenticationToken  authenticationToken =new UsernamePasswordAuthenticationToken(username,null,authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
            // TODO Auto-generated method stub
        }


	}

}
