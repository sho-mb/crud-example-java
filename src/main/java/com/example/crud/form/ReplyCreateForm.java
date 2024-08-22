package com.example.crud.form;

import com.example.crud.model.entity.Reply;

public record ReplyCreateForm(
  String discription
) {
  public Reply toReply() {
    Reply reply = Reply.builder()
    .discription(discription)
        .build();
    return reply;
  }

}
