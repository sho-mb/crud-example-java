package com.example.crud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.dao.TweetRepository;
import com.example.crud.model.entity.Tweet;

import com.example.crud.service.TweetService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

  private final TweetRepository tweetRepository;

  @Override
  public Tweet compose(Tweet tweet) {
    return tweetRepository.save(tweet);
  }

  @Override
  public List<Tweet> getAllTweet() {
    return tweetRepository.findAll();
  }

  @Override
  public List<Tweet> getTweetsForTimeLine(List<Long> userIds) {
    return tweetRepository.findByAccountIdInOrderByPostedAtDesc(userIds);
  }

  // @Override
  // public List<Tweet> getTweetsForTimeLine(List<Long> userIds, Pageable pageable) {
  //   return tweetRepository.findByAccountIds(userIds, pageable);
  // }

}
