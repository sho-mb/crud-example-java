package com.example.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
  Tweet save(Tweet tweet);
}
