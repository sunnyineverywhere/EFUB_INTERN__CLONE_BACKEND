package com.efub.twitter_clone.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EntityScan
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNum; //AUTO_INCREMENT

    @Column(length = 45, nullable = false)
    private String userId;

    @Column(length = 45, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String password;


    @Builder
    public User(String userId, String nickname)
    {
        this.userId = userId;
        this.nickname = nickname;
    }

}
