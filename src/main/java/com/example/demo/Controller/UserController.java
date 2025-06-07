package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.UserService;
import com.example.demo.Binding.User;
import com.example.demo.Identity.UserTable;
import com.example.demo.Repository.UserRepo;

@Controller
public class UserController {
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	
	public UserController(UserRepo userRepo) {
		this.userRepo=userRepo;
	}
	
	@GetMapping("/")
	public String displayForm(Model model) {
		model.addAttribute("user", new User());
		return "index";	
	}
	
	@PostMapping("/form-submit")
	@ResponseBody
	public User saveData(User user) {
		System.out.println(user);
		return user;
		
	}
	
	@PostMapping("/saveto-table")
	public String saveDataToEntity(User user) {
		UserTable user1=new UserTable();
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPhno(user.getPhno());
		userRepo.save(user1);
		return "user-list";
		
	}
	@GetMapping("/users")
	public String getAllTheUsers(Model model) {
		Iterable<UserTable> usersList=userService.viewUsers();
		model.addAttribute("users", usersList);
		return "user-list";
		
	}
	
}
