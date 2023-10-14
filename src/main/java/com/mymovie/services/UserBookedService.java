package com.mymovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.mymovie.entities.UserBooked;
import com.mymovie.repositories.UserBookedRepository;

@Service
public class UserBookedService {
	@Autowired
	private UserBookedRepository bookedRepository;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public void save(UserBooked userBooked) {
		bookedRepository.save(userBooked);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public List<UserBooked> getAll(int id) {
		return bookedRepository.findAllById(id);
	}
}
