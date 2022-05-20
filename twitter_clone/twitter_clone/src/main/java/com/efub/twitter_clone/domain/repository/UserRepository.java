package com.efub.twitter_clone.domain.repository;


import com.efub.twitter_clone.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Long, User> {
}
