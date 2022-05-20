package com.efub.twitter_clone.controller.dto;

import com.efub.twitter_clone.domain.entity.Post;

import com.efub.twitter_clone.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDTO {
    private User user;
    private String contents;

    @Builder
    public PostRequestDTO(User user, String contents)
    {
        this.user = user;
        this.contents = contents;

    }

}
