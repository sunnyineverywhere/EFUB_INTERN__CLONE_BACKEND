package com.efub.twitter_clone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.efub.twitter_clone.domain.entity.Post;


public interface PostRepository extends JpaRepository<Post, Long> {
}
