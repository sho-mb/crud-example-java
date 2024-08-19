package com.example.crud.service.impl;

import org.springframework.stereotype.Service;

import com.example.crud.dao.RetweetRepository;
import com.example.crud.service.RetweetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetweetServiceImpl implements RetweetService{
  private final RetweetRepository retweetRepository;

  @Override
  public long countRetweetByTweetId(Long tweetId) {
    return retweetRepository.countByTweetId(tweetId);
  }

}
