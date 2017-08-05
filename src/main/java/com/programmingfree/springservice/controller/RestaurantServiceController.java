package com.programmingfree.springservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.programmingfree.springservice.dao.RestaurantService;
import com.programmingfree.springservice.domain.Restaurant;

@RestController
@RequestMapping("/restaurant/menu_items.json")
public class RestaurantServiceController {

	RestaurantService restaurantService = new RestaurantService();

	
	@RequestMapping(value = "/{category}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Restaurant> getMenus(@PathVariable String category) {
		List<Restaurant> menus = restaurantService.getMenuByCategory(category);
		return menus;
	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Restaurant> getAllMenus() {
		List<Restaurant> menus = restaurantService.getAllMenu();
		return menus;
	}

}
