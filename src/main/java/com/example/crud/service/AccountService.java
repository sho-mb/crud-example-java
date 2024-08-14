package com.example.crud.service;

import org.apache.coyote.BadRequestException;

import com.example.crud.model.entity.Account;

public interface AccountService {
  Account register(Account account);

  Account getAccountById(Long id) throws BadRequestException;
}
