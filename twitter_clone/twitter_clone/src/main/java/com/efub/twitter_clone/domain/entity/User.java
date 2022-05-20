package com.efub.twitter_clone.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User{
    @Id

    private Long user_id;

    @Column(length = 45, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String password;

    @Builder
    public User(String nickname, String password)
    {
        this.nickname = nickname;
        this.password = password;
    }

}
