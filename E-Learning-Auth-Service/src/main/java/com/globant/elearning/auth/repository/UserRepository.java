package com.globant.elearning.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.elearning.auth.entity.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

	public MyUser findByUserName(String userName);

	public MyUser findByEmail(String email);

}
