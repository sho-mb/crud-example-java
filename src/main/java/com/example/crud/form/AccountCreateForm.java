package com.example.crud.form;

import com.example.crud.model.entity.Account;

public record AccountCreateForm(
  String username,
  String userId,
  String livingLocation) {
  public Account toAccountUser() {
      Account account = Account.builder()
      .username(username)
      .userId(userId)
      .livingLocation(livingLocation)
          .build();
      return account;
    } 
}
