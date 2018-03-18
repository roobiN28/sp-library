package com.robin.library.controller;

import com.robin.library.domain.User;
import com.robin.library.service.UserService;
import com.robin.library.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
	private UserService userService = new UserServiceImpl();

	@RequestMapping(value = "add", method = RequestMethod.POST)
	void all(@RequestBody User user) {
		userService.add(user);
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	void update(@RequestBody User user) {
		userService.update(user);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	List<User> all() {
		return userService.all();
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	User delete(@PathVariable Integer id) {
		return userService.delete(id);
	}
}
