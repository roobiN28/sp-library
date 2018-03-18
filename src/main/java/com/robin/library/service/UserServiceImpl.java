package com.robin.library.service;

import com.robin.library.domain.User;
import com.robin.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;


	@Override
	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	public Optional<User> get(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public List<User> all() {
		return userRepository.findAll();
	}
}
