package com.robin.library.repository;

import com.robin.library.domain.User;

import java.util.List;

public interface UserRepository {
	void add(User user);

	User get(Integer id);

	void update(User user);

	User delete(Integer id);

	List<User> all();
}
