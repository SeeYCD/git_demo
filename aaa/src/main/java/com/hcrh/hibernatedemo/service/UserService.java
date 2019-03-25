package com.hcrh.hibernatedemo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcrh.hibernatedemo.dao.UserRepository;
import com.hcrh.hibernatedemo.entity.User;

@Service
public class UserService {
	@Resource
	private UserRepository ur;

	public User findById(Long id) {
		return ur.findById(id);
	}

	public User save(User user) {
		return ur.save(user);
	}

	public User findName(String name) {
		return ur.findName(name);
	}

	public Integer updateAgeByName(String name, Integer age) {
 		return ur.updateAgeByName(name, age);
	}

}
