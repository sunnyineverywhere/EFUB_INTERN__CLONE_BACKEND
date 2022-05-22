package com.efub.twitter_clone.controller.dto;


import com.efub.twitter_clone.domain.entity.Post;
import com.efub.twitter_clone.domain.entity.User;

import lombok.*;





import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDTO {
    private Long postId;
    private String contents;
    private String userId;
    private String nickname;

    
    @Builder
    public PostResponseDTO(Post entity){
        this.postId = entity.getPostId();
        this.contents = entity.getContents();
        this.userId= entity.getUser().getUserId();
        this.nickname = entity.getUser().getNickname();

    }
}
