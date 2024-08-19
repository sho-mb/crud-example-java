package com.example.crud.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

  Optional<Account> findByUserId(String userId);
}
