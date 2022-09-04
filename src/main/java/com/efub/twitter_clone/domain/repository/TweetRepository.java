package com.efub.twitter_clone.domain.repository;

import com.efub.twitter_clone.domain.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
