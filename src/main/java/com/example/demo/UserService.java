package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Binding.User;
import com.example.demo.Identity.UserTable;
import com.example.demo.Repository.UserRepo;

@Service
public class UserService {
	private UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo=userRepo;
	}
	
	public Iterable<UserTable> viewUsers() {
		Iterable <UserTable> userList=userRepo.findAll();
		return userList;
	}

}
