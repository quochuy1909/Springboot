package com.ntqh.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ntqh.model.Movies;

public interface MoviesDAO extends JpaRepository<Movies, Integer> {

}
