package com.example.crud.form;

import com.example.crud.model.entity.Reply;

public record ReplyCreateForm(
  String userId,
  String discription,
  long tweetId
) {
  public Reply toReply() {
    Reply reply = Reply.builder()
    .discription(discription)
        .build();
    return reply;
  }

}
