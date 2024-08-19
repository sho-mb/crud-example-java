package com.example.crud.model.entity;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tweet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String discription;

  @Column(nullable = false)
  @CreationTimestamp
  private Date postedAt;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet", orphanRemoval = true, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Reply> replies = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet", orphanRemoval = true, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<UserLike> likes = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet", orphanRemoval = true, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Retweet> retweets = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "account_id", nullable = false)
  private Account account;
}
