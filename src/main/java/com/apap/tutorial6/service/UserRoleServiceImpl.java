package com.apap.tutorial6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apap.tutorial6.model.UserRoleModel;
import com.apap.tutorial6.repository.UserRoleDB;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleDB userDb;
	
	@Override
	public UserRoleModel addUser(UserRoleModel user) {
		String pass = encrypt(user.getPassword());
		user.setPassword(pass);
		return userDb.save(user);
	}
	
	
	@Override
	public String encrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}
	
//	@Override
//	public Boolean cekPassword(String username, PasswordModel pass) {
//		UserRoleModel userTarget = userDb.findByUsername(username);
//		return passwordEncoder.matches(pass.getPasswordLama(), userTarget.getPassword() );
//	}
//	
//	@Override
//	public void updatePassword(String username, PasswordModel pass) {
//		UserRoleModel userTarget = userDb.findByUsername(username);
//		String passBaru = encrypt(pass.getPasswordBaru());
//		userTarget.setPassword(passBaru);
//		userDb.save(userTarget);
//	}
}
