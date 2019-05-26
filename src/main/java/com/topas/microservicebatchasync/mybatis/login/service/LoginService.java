package com.topas.microservicebatchasync.mybatis.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topas.microservicebatchasync.mybatis.login.dto.Login;
import com.topas.microservicebatchasync.mybatis.user.mapper.UserMapper;
import com.topas.microservicebatchasync.mybatis.user.model.User;

@Service
public class LoginService {
	@Autowired
	private UserMapper userMapper;

	public void authenticate(Login login) {
		User user = userMapper.selectByEmail(login.getEmail());
		if (user == null) {
			login.setError("Email does not exist.");
		} else {
			if (!user.getPassword().equals(login.getPassword())) {
				login.setError("Password is not correct.");
			} else {
				login.setError(null);
			}
		}
	}
}
