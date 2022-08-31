package com.efub.twitter_clone.domain.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tweet")
public class Tweet extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId; //AUTO_INCREMENT

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @ManyToOne//단반향
    @JoinColumn(name = "member_id")
    private Member member;

    public void update(String contents) {
        this.contents = contents;
    }

    @Builder
    public Tweet(Long postId, Member member, String contents)
    {
        this.postId = postId;
        this.member = member;
        this.contents = contents;
    }

}


