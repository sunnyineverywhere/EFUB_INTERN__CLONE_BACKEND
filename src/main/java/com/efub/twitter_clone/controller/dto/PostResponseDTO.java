package com.efub.twitter_clone.controller.dto;


import com.efub.twitter_clone.domain.entity.Post;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDTO {
    private Long postId;
    private String contents;
    private Long memberId;
    private String nickname;

    
    @Builder
    public PostResponseDTO(Post entity){
        this.postId = entity.getPostId();
        this.contents = entity.getContents();
        this.memberId= entity.getMember().getMemberId();
        this.nickname = entity.getMember().getNickname();

    }
}
