package com.efub.twitter_clone.controller.dto;

import com.efub.twitter_clone.domain.entity.Post;

import com.efub.twitter_clone.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDTO {
    private String user_id; //닉네임으로 넣기
    private String nickname;
    private String contents;


    public Post toEntity()
    {
        Post build = Post.builder()
                .contents(contents)
                .user_id(user_id)
                .nickname(nickname)
                .build();
        return build;
    }

    @Builder
    public PostRequestDTO(String user_id, String nickname, String contents)
    {
        this.user_id = user_id;
        this.nickname = nickname;
        this.contents = contents;

    }

}
