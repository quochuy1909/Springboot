package com.ntqh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntqh.model.Users;

public interface UsersDAO extends JpaRepository<Users, Integer> {

}
