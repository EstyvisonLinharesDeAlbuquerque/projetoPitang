package com.pitang.treinamento.service;

import java.util.List;

import com.pitang.treinamento.model.UserModel;


public interface UserService {
	
	public List<UserModel> listUsers();
	
	public UserModel findUserByEmail(String email);

	public UserModel addUser(UserModel userModel);
}
