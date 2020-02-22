package com.pitang.treinamento.serviceImpl;

import java.util.List;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pitang.treinamento.exceptions.ExceptionBadRequest;
import java.util.Optional;
import com.pitang.treinamento.exceptions.ExceptionConflict;
import com.pitang.treinamento.model.UserModel;
import com.pitang.treinamento.repository.UserRepository;
import com.pitang.treinamento.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserModel> listUsers() {
		if (userRepository.findAll().size() == 0) {
			return null;
		}
		return userRepository.findAll();
	}

	@Override
	public UserModel findUserByEmail(String email) {
		if (userRepository.findAll().size() == 0) {
			return null;
		}
		return userRepository.findByEmail(email);
	}

	@Override
	public UserModel addUser(UserModel userModel) {
		validateUser(userModel);
		checkIntegrityUser(userModel);
		return userRepository.save(userModel);
	}
	
	@Override
	public UserModel updateUser(Long id ,UserModel user) {
		if(id == null) {
			throw new ExceptionBadRequest("Necessário informar o id para atualizar!");
		}
		///checkIntegrity(user);
		UserModel userDb = userRepository.findById(id).get();
		userDb.setName(user.getName());
		
		
		//validateUser(user);
		return userRepository.save(userDb);
	}
	
	@Override
	public void deleteUser(Long id) {
		
		if(verifyUser(id)) {
			userRepository.deleteById(id);
		}
	}
	
	@Override
	public boolean verifyUser(Long id) {
		Optional<UserModel> user = userRepository.findById(id);
		return user.isPresent();
	}

	private void validateUser(UserModel user) {
		if (!StringUtils.isEmpty(user.getEmail()) && userRepository.findByEmail(user.getEmail()) != null) {
			throw new ExceptionConflict("Email informado já existe!");
		}
		if(!StringUtils.isEmpty(user.getUsername()) && userRepository.findByUsername(user.getUsername()) != null) {
			throw new ExceptionConflict("Nome de usuário informado já existe!");
		}
	}
	
	/*
	protected void checkIntegrityUser(UserModel user) {
		checkMandatoryFields(user);
		}
	*/
	
	private void checkIntegrityUser(UserModel user) {
		if (user == null) {
			throw new ExceptionBadRequest("Usuário não pode ser nulo!");
		}
		if (StringUtils.isEmpty(user.getEmail())) {
			throw new ExceptionBadRequest("Necessário informar o Email do usuário.");
		}
		if (StringUtils.isEmpty(user.getName())) {
			throw new ExceptionBadRequest("Necessário informar o Nome do usuário.");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			throw new ExceptionBadRequest("Necessário informar a Senha do usuário.");
		}
		if (StringUtils.isEmpty(user.getUsername())) {
			throw new ExceptionBadRequest("Necessário informar o Nome do usuário.");
		}
	}
}