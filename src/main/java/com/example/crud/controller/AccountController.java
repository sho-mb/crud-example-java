package com.example.crud.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.form.AccountCreateForm;
import com.example.crud.model.entity.Account;
import com.example.crud.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @GetMapping("{userId}")
  public Account getAccountByUserId(
    @PathVariable(name = "userId") String userId
  ) throws BadRequestException {
    return accountService.getAccountByUserId(userId);
  }

  @PostMapping("/register")
  public Account register(@RequestBody AccountCreateForm accountCreateForm) {
    return accountService.register(accountCreateForm.toAccountUser());
  }
}
