package com.robin.library.service;

import com.robin.library.domain.User;
import com.robin.library.repository.UserRepository;
import com.robin.library.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public void add(User user) {
		userRepository.add(user);
	}

	@Override
	public User get(Integer id) {
		return userRepository.get(id);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public User delete(Integer id) {
		return userRepository.delete(id);
	}

	@Override
	public List<User> all() {
		return userRepository.all();
	}
}
