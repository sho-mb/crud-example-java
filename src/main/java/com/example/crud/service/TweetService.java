package com.example.crud.service;

import java.util.List;

import org.springframework.data.domain.Limit;

import com.example.crud.model.entity.Tweet;

public interface TweetService {
  Tweet compose(Tweet tweet);

  List<Tweet> getAllTweet();

  List<Tweet> getTweetsForTimeLine(List<Long> userId);

  // List<Tweet> getTweetsForTimeLine(List<Long> userIds, Pageable pageable);
}
