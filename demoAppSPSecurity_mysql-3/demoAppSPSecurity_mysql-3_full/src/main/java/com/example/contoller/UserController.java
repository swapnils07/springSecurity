package com.example.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entites.Users;
import com.example.service.UsersService;
import com.example.util.MyResponse;


@RestController
@RequestMapping("/user")
public class UserController  {

	@Autowired
	UsersService userService;

	@GetMapping("/users")
	public MyResponse<List<Users>> getAllUsers(){
		List<Users> userList=userService.getAllUsers();
		MyResponse<List<Users>> myResp=new MyResponse<List<Users>>();
		myResp.setStatus(200);
		myResp.setMessage("User List Sucess");
		myResp.setData(userList);
		return myResp;
	}

	@PostMapping("/create")
	public MyResponse<Users> createNewUser(@RequestBody Users users){
		Users sa=userService.createNewUser(users);
		MyResponse<Users> myResp=new MyResponse<Users>();
		myResp.setStatus(200);
		myResp.setMessage("User saved Sucess");
		myResp.setData(sa);
		return myResp;
	}
	
	
	@GetMapping("/demo")
	public Users demo() {
		return userService.getUser("swap");
	}


}
