package com.example.crud.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.form.ReplyCreateForm;
import com.example.crud.model.entity.Reply;
import com.example.crud.service.AccountService;
import com.example.crud.service.ReplyService;
import com.example.crud.service.TweetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

  private final AccountService accountService;
  private final TweetService tweetService;
  private final ReplyService replyService;

  @GetMapping("/{tweetId}")
  public long getTweetWithRepliesCount(@PathVariable Long tweetId) {
    return replyService.countRepliesByTweetId(tweetId);
  }

  @PostMapping
  public Reply addReply(@RequestBody ReplyCreateForm replyCreateForm) throws BadRequestException {
    Reply reply = replyCreateForm.toReply();
    reply.setAccountId(accountService.getAccountByUserId(replyCreateForm.userId()));
    reply.setTweet(tweetService.getTweetById(replyCreateForm.tweetId()));
    return replyService.addReply(reply);
  }
}
