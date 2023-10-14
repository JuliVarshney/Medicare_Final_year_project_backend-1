package com.mymovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymovie.entities.Movie;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	Movie findById(int id);
}
