package com.mymovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.entities.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {

	User findByName(String username);

}
