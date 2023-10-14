package com.mymovie.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {


}
