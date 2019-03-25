package com.hcrh.hibernatedemo.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcrh.hibernatedemo.entity.User;

@Service
public class UserService2 {
	@Resource
	private UserService us1;

	@Transactional
	public User findById(Long id) {
		User u=us1.findById(id);
		u.setName("100000");
		return u;
	}
	@Transactional
	public User save(User user) {
		us1.save(user);
		System.out.println("------------分割----------");
		user.setName("shenc1");//测试当前user对象是否是持久态，结果是没有变更到数据库，说明是离线状态
		return user;
	}
	@Transactional
	public Integer updateAgeByName(String name,Integer age ) {
		return us1.updateAgeByName(name, age);
 	}

 	
}
