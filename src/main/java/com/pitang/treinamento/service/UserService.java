package com.pitang.treinamento.service;

import java.util.List;

import com.pitang.treinamento.model.UserModel;


public interface UserService {
	
	public List<UserModel> listUsers();
	
	public UserModel findUserByEmail(String email);

	public UserModel addUser(UserModel userModel);
	
	public UserModel updateUser(Long id ,UserModel userModel);
	
	public void deleteUser(Long id);

	public UserModel buscarUser(Long id);
	
}