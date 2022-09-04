package com.efub.twitter_clone.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 요청

@Getter
@NoArgsConstructor
public class TweetRequestDTO {
    private String contents;

    @Builder
    public TweetRequestDTO(String contents)
    {
        this.contents = contents;
    }

}

