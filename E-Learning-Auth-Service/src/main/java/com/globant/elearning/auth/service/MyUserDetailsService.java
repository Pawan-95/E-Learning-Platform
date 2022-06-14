package com.globant.elearning.auth.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.globant.elearning.auth.entity.JwtRequest;
import com.globant.elearning.auth.entity.JwtResponse;
import com.globant.elearning.auth.entity.MyUser;
import com.globant.elearning.auth.repository.UserRepository;
import com.globant.elearning.auth.util.JwtUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {

		String userName = jwtRequest.getUserName();
		String password = jwtRequest.getPassword();

		authenticate(userName, password);

		final UserDetails userDetails = loadUserByUsername(userName);

		String generatedJwtToken = jwtUtil.generateToken(userDetails);

		return new JwtResponse(generatedJwtToken);

	}

	private void authenticate(String username, String password) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("User is Disable " + e.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials " + e.getMessage());
		}

	}

	private Set<SimpleGrantedAuthority> getAuthorities(MyUser user) {

		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();

		user.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));

		});
		return authorities;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		MyUser appUser = userRepository.findByUserName(userName);

		if (appUser != null) {
			return new User(appUser.getUserName(), appUser.getPassword(), getAuthorities(appUser));
		} else {
			throw new UsernameNotFoundException("UserName not found..!!");

		}

	}

}
