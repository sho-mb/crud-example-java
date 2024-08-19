package com.example.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

  long countByTweetId(Long tweetId);

}
