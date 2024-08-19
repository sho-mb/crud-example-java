package com.example.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.entity.UserLike;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {

  long countByTweetId(Long tweetId);

}
