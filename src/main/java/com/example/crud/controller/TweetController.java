package com.example.crud.controller;

import org.apache.coyote.BadRequestException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.data.domain.Limit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.form.CreateTweetForm;
import com.example.crud.model.entity.Account;
import com.example.crud.model.entity.Tweet;
import com.example.crud.service.AccountService;
import com.example.crud.service.TweetService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/tweet")
@RequiredArgsConstructor
public class TweetController {

  private final TweetService tweetService;
  private final AccountService accountService;

  // @GetMapping()
  // public List<Tweet> getTweets() {
  //   return tweetService.getAllTweet();
  // }

  @GetMapping("timeline")
  public List<Tweet> getTimeline(
      @RequestParam Long userId
  ) {
    // todo get following accIds
    List<Long> userIds = new ArrayList<>();
    userIds.add(userId);
    List<Tweet> tweets = tweetService.getTweetsForTimeLine(userIds);
    return tweets;
  }

  @PostMapping("/{id}/CreateTweet")
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
