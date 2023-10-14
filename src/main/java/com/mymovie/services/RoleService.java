package com.mymovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovie.entities.Role;
import com.mymovie.repositories.RoleRepository;

@Service("role_service")
public class RoleService {
	@Autowired
	private RoleRepository repository;

	public List<Role> getRoles() {
		return repository.findAll();
	}

	public Role getRoleById(int id) {
		return repository.findById(id).get();
	}

}
