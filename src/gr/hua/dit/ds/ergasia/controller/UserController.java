/*package gr.hua.dit.ds.ergasia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gr.hua.dit.ds.ergasia.dao.UserDAO;
//import gr.hua.dit.ds.ergasia.entity.Form;
import gr.hua.dit.ds.ergasia.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> users = userDAO.getUsers();
		return users;
	}
	
	/*@GetMapping("/forms")
	public List<Form> getForms(){
		List<Form> forms=userDAO.getForms();
		return forms;
	}
*/

