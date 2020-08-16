package com.techpassel.springbootjpamysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpassel.springbootjpamysql.model.User;
import com.techpassel.springbootjpamysql.repository.UserRepo;

@Controller
public class UserController {
	
	@Autowired
	UserRepo repo;
	
	@RequestMapping("/")
	public String addUser() {
		return "addUser";
	}
	
	@RequestMapping("/add")
	public ModelAndView saveUser(User user) {
		repo.save(user);
		List<User> l = (List<User>) repo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayUser");
		mv.addObject("users", l);
		return mv;
	}
	
	@RequestMapping("/details")
	public ModelAndView getDetails(String name) {
		//To find one user with matching name;
		//User u = repo.findByName(name);
		
		//To find all user with matching name in sorted order;
		List<User> u = repo.findByNameSorted(name);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userDetails");
		mv.addObject("user", u);
		return mv;
	}
	
	@RequestMapping("/sort")
	public ModelAndView sortUsers() {
		List<User> l = (List<User>) repo.findAllByNameSorted();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayUser");
		mv.addObject("users", l);
		return mv;
	}
}
