package com.example.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.entity.Retweet;

public interface RetweetRepository extends JpaRepository<Retweet, Long> {

  long countByTweetId(Long tweetId);

}
