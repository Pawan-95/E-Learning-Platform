package com.globant.elearning.auth.entity;

public class JwtResponse {

	private String jwtToken;

	public JwtResponse(String jwtToken) {
		super();

		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

}
