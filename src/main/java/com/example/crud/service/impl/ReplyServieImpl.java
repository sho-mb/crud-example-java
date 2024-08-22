package com.example.crud.service.impl;

import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.crud.dao.ReplyRepository;
import com.example.crud.model.entity.Reply;
import com.example.crud.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReplyServieImpl implements ReplyService {

  private final ReplyRepository replyRepository;

  @Override
  public Reply addReply(Reply reply) {
    return replyRepository.save(reply);
  }

  @Override
  public long countRepliesByTweetId(Long tweetId) {
    return replyRepository.countByTweetId(tweetId);
  }

  @Override
  public List<Reply> getReplies(Long tweetId) {
    return replyRepository.findByTweetId(tweetId);
  }
  
}
