package com.example.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
