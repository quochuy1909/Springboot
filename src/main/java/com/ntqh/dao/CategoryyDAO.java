package com.ntqh.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntqh.model.Categoryy;

public interface CategoryyDAO extends JpaRepository<Categoryy, Integer> {
	Optional<Categoryy> findCateByName(String name);
}
