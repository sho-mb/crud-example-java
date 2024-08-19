package com.example.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
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

  @Override
  public boolean deleteTweet(Long id) throws BadRequestException {
    try {
      Optional<Tweet> target = tweetRepository.findById(id);
      if (target.isPresent()) {
        tweetRepository.deleteById(id);
        return true;
      } else {
        throw new BadRequestException("Tweet not found with id: " + id);
      }
    } catch (IllegalArgumentException e) {
        throw new BadRequestException("Invalid id: " + id, e);
    }
  }

  @Override
  public Tweet getTweetById(long tweetId) throws BadRequestException {
    try {
      Optional<Tweet> optTweet = tweetRepository.findById(tweetId);
      return optTweet.get();
    } catch (IllegalArgumentException e) {
        throw new BadRequestException("Invalid id: " + tweetId, e);
    }
  }
}
