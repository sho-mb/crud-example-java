package com.example.crud.service;

import java.util.List;

import org.apache.coyote.BadRequestException;

import com.example.crud.model.entity.Tweet;

public interface TweetService {
  Tweet compose(Tweet tweet);

  List<Tweet> getAllTweet();

  List<Tweet> getTweetsForTimeLine(List<Long> userId);

  boolean deleteTweet(Long id) throws BadRequestException;
}
