package com.globant.elearning.auth.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.elearning.auth.entity.JwtRequest;
import com.globant.elearning.auth.entity.JwtResponse;
import com.globant.elearning.auth.entity.MyUser;
import com.globant.elearning.auth.exception.UserAlreadyRegisteredException;
import com.globant.elearning.auth.service.MyUserDetailsService;
import com.globant.elearning.auth.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody MyUser myUser) throws UserAlreadyRegisteredException {

		// checking retyped password matches or not
		if (!myUser.getPassword().equals(myUser.getMatchingPassword())) {
			return new ResponseEntity<>("Password do not match", HttpStatus.BAD_REQUEST);
		}

		List<String> msg = userService.registerNewUser(myUser);

		if (msg.isEmpty()) {
			return new ResponseEntity<>("Registration Successful", HttpStatus.OK);
		}

		return new ResponseEntity<>(msg, HttpStatus.CONFLICT);
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		JwtResponse jwtResponse = myUserDetailsService.createJwtToken(jwtRequest);

		if (jwtResponse == null) {
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
		}

	}

}
