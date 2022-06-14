package com.globant.elearning.auth.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.elearning.auth.entity.MyUser;
import com.globant.elearning.auth.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<String> registerNewUser(MyUser myUser) {

		List<String> msg = new ArrayList<String>();

		MyUser userName = userRepository.findByUserName(myUser.getUserName());

		MyUser userEmail = userRepository.findByEmail(myUser.getEmail());

		int count = 0;

		if (userName != null) {
			msg.add("Username already registered. Please proceed with login");
			count++;
		} else if (userEmail != null) {
			msg.add("Email associated with another account. Please use different email.");
			count++;
		}

		if (count == 0) {
			userRepository.save(myUser);
		}
		return msg;

	}

}
