package com.andrade.security.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.andrade.security.domain.User;

@Repository
public interface  UserRepository extends JpaRepository<User,UUID>{
    Optional<UserDetails> findUserByEmail(String email);
}
