package com.efub.twitter_clone.domain.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "post")
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId; //AUTO_INCREMENT

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "userNum", updatable = false)
    private User user;

    public void update(String contents) {
        this.contents = contents;
    }

    @Builder
    public Post(Long postId, User user, String contents)
    {
        this.postId = postId;
        this.user = user;
        this.contents = contents;
    }

}


