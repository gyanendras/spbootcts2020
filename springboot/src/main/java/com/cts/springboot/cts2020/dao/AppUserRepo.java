package com.cts.springboot.cts2020.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.springboot.cts2020.User;

@Repository
public interface AppUserRepo extends JpaRepository<User, Integer> {
	User findByUserName(String username);

}
