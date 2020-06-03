package com.project.service.serviceImpl;

import com.project.dao.UserDao;
import com.project.pojo.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService1")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public List<User> selectUser() {
		return userDao.selectUser();
	}
}
