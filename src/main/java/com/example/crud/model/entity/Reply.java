package com.example.crud.model.entity;

import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String discription;

  // @CreationTimestamp
  // @Column(nullable = false)
  // private Date createdAt;

  @ManyToOne
  @JoinColumn(name = "tweet_id")
  private Tweet tweet;

  @JoinColumn(name = "account_id")
  @ManyToOne
  private Account account;
}
