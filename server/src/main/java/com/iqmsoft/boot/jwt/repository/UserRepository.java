package com.iqmsoft.boot.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iqmsoft.boot.jwt.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}

