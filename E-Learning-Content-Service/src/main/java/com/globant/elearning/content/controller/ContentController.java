package com.globant.elearning.content.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/content")
public class ContentController {

	@GetMapping("/fetch/admin")
	public String getAdminContent() {

		return "Welcome to admin content";
	}

	@GetMapping("/fetch/user")
	public String getUserContent() {

		return "Welcome to user content";
	}
}
