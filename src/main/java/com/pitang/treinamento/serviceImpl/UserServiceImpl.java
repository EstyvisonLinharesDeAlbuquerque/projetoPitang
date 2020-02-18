package com.pitang.treinamento.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitang.treinamento.model.UserModel;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserModel> listUsers() {
		if(userRepository.findAll().size() == 0) {
			return null;
		}
		return userRepository.findAll();
	}

	@Override
	public UserModel findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
