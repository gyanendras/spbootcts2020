package com.cts.springboot.cts2020;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class User {
		
	public User() {
		super();
	}
	
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}



	@Id
	int id;
	private  String userName;
	private  String password;

}
