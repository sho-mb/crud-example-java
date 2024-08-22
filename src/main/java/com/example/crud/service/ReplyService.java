package com.example.crud.service;
import java.util.List;
import com.example.crud.model.entity.Reply;

public interface ReplyService {

  Reply addReply(Reply reply);

  long countRepliesByTweetId(Long tweetId);

  List<Reply> getReplies(Long tweetId);

}
