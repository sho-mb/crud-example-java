package com.example.crud.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.dao.UserLikeRepository;
import com.example.crud.service.UserLikeService;

import lombok.RequiredArgsConstructor;

@Transactional
@Repository
@RequiredArgsConstructor
public class UserLikeServiceImpl implements UserLikeService {

  private final UserLikeRepository userLikeRepository;

  @Override
  public long countUserLikeByTweetId(Long tweetId) {
    return userLikeRepository.countByTweetId(tweetId);
  }
}
