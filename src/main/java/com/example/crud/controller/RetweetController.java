package com.example.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.service.RetweetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/retweet")
@RequiredArgsConstructor
public class RetweetController {
  private final RetweetService retweetService;

  @GetMapping("/{tweetId}")
  public long getTweetWithRepliesCount(@PathVariable Long tweetId) {
    return retweetService.countRetweetByTweetId(tweetId);
  }

}
