package com.example.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
  Tweet save(Tweet tweet);

  List<Tweet> findByAccountIdInOrderByPostedAtDesc(List<Long> userIds);
}
