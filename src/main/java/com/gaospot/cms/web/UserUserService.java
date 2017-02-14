package com.gaospot.cms.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gaospot.cms.db.UserRepository;
import com.gaospot.cms.domain.Users;

public class UserUserService implements UserDetailsService {
	
	private final UserRepository userRepository;

	public UserUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		if (user != null) {
			List<GrantedAuthority> authorities = 
					new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			return new User(
					user.getUsername(),
					user.getUsername(),
					authorities);
		}
		throw new UsernameNotFoundException(
				"User '" + username + "' not found.");
	}
}
