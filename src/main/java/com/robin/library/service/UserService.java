package com.robin.library.service;

import com.robin.library.domain.User;

import java.util.List;

public interface UserService {
	void add(User user);

	User get(Integer id);

	void update(User user);

	User delete(Integer id);

	List<User> all();
}
