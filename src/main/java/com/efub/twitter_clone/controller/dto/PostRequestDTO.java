package com.efub.twitter_clone.controller.dto;

import com.efub.twitter_clone.domain.entity.Post;

import com.efub.twitter_clone.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 요청

@Getter
@NoArgsConstructor
public class PostRequestDTO {
    private Long postId;
    private Long userNum;
    private String contents;

    @Builder
    public PostRequestDTO(Long userNum, String contents)
    {
        this.userNum = userNum;
        this.contents = contents;
    }

}

