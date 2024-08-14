package com.example.crud.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.form.CreateTweetForm;
import com.example.crud.model.entity.Account;
import com.example.crud.model.entity.Tweet;
import com.example.crud.service.AccountService;
import com.example.crud.service.TweetService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/compose")
@RequiredArgsConstructor
public class TweetController {

  private final TweetService tweetService;
  private final AccountService accountService;

  @GetMapping
  public void helloworld() {
    System.out.println("helloworld");
  }

  @PostMapping("{id}/CreateTweet")
  public ResponseEntity<Tweet> createTweet(
      @PathVariable(name = "id") Long id,
      @RequestBody CreateTweetForm createTweetForm) throws BadRequestException {
    Account account = accountService.getAccountById(id);
    if (account == null) {
      throw new BadRequestException("Account not found");
    }
    Tweet tweet = createTweetForm.toTweet();
    tweet.setAccount(account);
    Tweet sevedTweet = tweetService.compose(tweet);
    return ResponseEntity.ok(sevedTweet);
  }

}
