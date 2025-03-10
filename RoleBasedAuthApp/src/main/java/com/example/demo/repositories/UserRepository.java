package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entries.UnivUser;

@Repository
public interface UserRepository extends JpaRepository<UnivUser, Integer>{

	UnivUser findByEmail(String email);

}
