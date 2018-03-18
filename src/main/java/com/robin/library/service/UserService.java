package com.robin.library.service;

import com.robin.library.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	void add(User user);

	Optional<User> get(Integer id);

	void update(User user);

	void delete(User user);

	List<User> all();
}
