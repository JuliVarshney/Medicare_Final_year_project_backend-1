package com.mymovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mymovie.entities.Screen;

@Repository("screenRepository")
public interface ScreenRepository extends JpaRepository<Screen, Integer> {

}
