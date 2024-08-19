package com.example.crud.service;

import com.example.crud.model.entity.Reply;

public interface ReplyService {

  Reply addReply(Reply reply);

  long countRepliesByTweetId(Long tweetId);

}
