package com.example.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.service.UserLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class UserLikeController {

  private final UserLikeService userLikeService;

  @GetMapping("/{tweetId}")
  public long getTweetWithUserLikeCount(@PathVariable Long tweetId) {
    return userLikeService.countUserLikeByTweetId(tweetId);
  }

}
