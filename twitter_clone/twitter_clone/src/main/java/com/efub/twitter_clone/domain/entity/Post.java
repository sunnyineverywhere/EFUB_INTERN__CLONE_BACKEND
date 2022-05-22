package com.efub.twitter_clone.domain.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue
    private Long post_id; //AUTO_INCREMENT

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;


    @Temporal(TemporalType.TIMESTAMP)//자동 생성을 위해
    private LocalDateTime post_date;

    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "user_num", updatable = false)
    private User user;
    //private Long user_id;

    @Builder
    public Post(User user, String contents)
    {
        this.user = user;
        this.contents = contents;
    }




}


