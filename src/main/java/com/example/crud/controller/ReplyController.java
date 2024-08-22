package com.example.crud.controller;

import org.apache.coyote.BadRequestException;
import java.util.List;
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

  @GetMapping("/count/{tweetId}")
  public long getTweetWithRepliesCount(@PathVariable Long tweetId) {
    return replyService.countRepliesByTweetId(tweetId);
  }

  @GetMapping("/{tweetId}")
  public List<Reply> getReplies(@PathVariable Long tweetId) {
    return replyService.getReplies(tweetId);
  }

  @PostMapping("/{userId}/{tweetId}")
  public Reply addReply(
      @RequestBody ReplyCreateForm replyCreateForm,
      @PathVariable(name = "userId") String userId,
      @PathVariable(name = "tweetId") long tweetId
  ) throws BadRequestException {
    System.out.println(userId);
    System.out.println(tweetId);
    System.out.println(replyCreateForm.discription());
    Reply reply = replyCreateForm.toReply();
    reply.setAccount(accountService.getAccountByUserId(userId));
    reply.setTweet(tweetService.getTweetById(tweetId));
    return replyService.addReply(reply);
  }
}
