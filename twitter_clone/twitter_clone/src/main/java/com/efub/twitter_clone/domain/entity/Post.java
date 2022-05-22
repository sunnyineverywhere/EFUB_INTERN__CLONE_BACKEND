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

    @Temporal(TemporalType.TIMESTAMP)//자동 생성을 위해
    private Date postDate;


    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "userNum", updatable = false)
    private User user;

    @Builder
    public Post(User user, String contents)
    {
        this.user = user;
        this.contents = contents;
    }

}


