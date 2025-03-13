package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TokenUser;

@Repository
public interface TokenGenerationRepository extends JpaRepository<TokenUser, Integer> {

	TokenUser getByName(String name);

}
