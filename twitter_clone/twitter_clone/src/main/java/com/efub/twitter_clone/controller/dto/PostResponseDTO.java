package com.efub.twitter_clone.controller.dto;


import com.efub.twitter_clone.domain.entity.Post;
import com.efub.twitter_clone.domain.entity.User;

import lombok.*;


import java.time.LocalDateTime;

import java.sql.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDTO {
    private Long post_id;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String user_id;
    private String nickname;


    
    @Builder
    public PostResponseDTO(Post entity){
        this.post_id = entity.getPost_id();
        this.user_id = entity.getUser_id();
        this.contents = entity.getContents();
        this.nickname = entity.getNickname();
        this.createAt = entity.getCreateAt();
        this.updateAt = entity.getUpdateAt();

    }
}
