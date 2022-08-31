package com.efub.twitter_clone.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 요청

@Getter
@NoArgsConstructor
public class TweetRequestDTO {
    private Long postId;
    private Long memberId;
    private String contents;

    @Builder
    public TweetRequestDTO(Long memberId, String contents)
    {
        this.memberId = memberId;
        this.contents = contents;
    }

}

