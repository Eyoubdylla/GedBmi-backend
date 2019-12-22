package banq.bmi.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import banq.bmi.entities.Utilisateur;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AccountServive accountServive;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur=accountServive.findUserByUsername(username);
		if(utilisateur==null)throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		utilisateur.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(utilisateur.getUsername(),utilisateur.getPassword(),authorities);
	}

}
