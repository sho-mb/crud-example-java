package com.example.crud.service.impl;

import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.example.crud.dao.AccountRepository;
import com.example.crud.model.entity.Account;
import com.example.crud.service.AccountService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  @Override
  public Account register(Account account) {
    return accountRepository.save(account);
  }

  @Override
  public Account getAccountById(Long id) throws BadRequestException {
    Optional<Account> optAccount = accountRepository.findById(id);
    if (optAccount.isPresent()) {
      return optAccount.get();
    } else {
      return optAccount.orElseThrow(() -> new BadRequestException("Account not found"));
    }
  }

  @Override
  public Account getAccountByUserId(String userId) throws BadRequestException {
    Optional<Account> optAccount = accountRepository.findByUserId(userId);
    if (optAccount.isPresent()) {
      return optAccount.get();
    } else {
      return optAccount.orElseThrow(() -> new BadRequestException("Account not found"));
    }
  }
}
