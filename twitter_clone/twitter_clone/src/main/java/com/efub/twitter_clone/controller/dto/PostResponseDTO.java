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
    private String user_id;
    private String nickname;
    private LocalDateTime post_date;

    
    @Builder
    public PostResponseDTO(Post entity){
        this.post_id = entity.getPost_id();
        this.contents = entity.getContents();
        this.user_id= entity.getUser().getUser_id();
        this.nickname = entity.getUser().getNickname();
        this.post_date = entity.getPost_date();
    }
}
