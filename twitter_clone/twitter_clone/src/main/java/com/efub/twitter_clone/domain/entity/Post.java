package com.efub.twitter_clone.domain.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Entity
@EntityScan
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Post {

    private String user_id;
    private String nickname;
    @Id
    @GeneratedValue
    private Long post_id; //AUTO_INCREMENT

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;



    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "num", updatable = false)
    private Long num;


    @Builder
    public Post(String user_id, String nickname , String contents)
    {
        this.nickname = nickname;
        this.user_id = user_id;
        this.contents = contents;

    }




}


