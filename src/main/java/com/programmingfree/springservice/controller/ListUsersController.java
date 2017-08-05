package com.programmingfree.springservice.controller;

import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.programmingfree.springservice.domain.User;




@Controller
public class ListUsersController {

	@RequestMapping("/listUsers")
	public ModelAndView listUsers() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/SpringJson/service/user/";
		List<LinkedHashMap> user = restTemplate.getForObject(url, List.class);
		return new ModelAndView("listUsers", "users", user);
	}

	@RequestMapping("/dispUser/{userid}")
	public ModelAndView dispUser(@PathVariable("userid") int id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/SpringJson/service/user/{userid}";
		User user = restTemplate.getForObject(url, User.class, id);
		return new ModelAndView("dispUser", "user", user);
	}

}
