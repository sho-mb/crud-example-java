package com.example.crud.form;

import com.example.crud.model.entity.Tweet;

public record CreateTweetForm(
  String discription
) {
  public Tweet toTweet() {
    Tweet tweet = Tweet.builder()
    .discription(discription)
        .build();
    return tweet;
  }

}
