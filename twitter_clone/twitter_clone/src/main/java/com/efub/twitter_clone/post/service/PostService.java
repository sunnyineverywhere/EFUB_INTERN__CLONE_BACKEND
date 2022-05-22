package com.efub.twitter_clone.post.service;

import com.efub.twitter_clone.controller.dto.PostRequestDTO;
import com.efub.twitter_clone.controller.dto.PostResponseDTO;

import com.efub.twitter_clone.domain.entity.Post;
import com.efub.twitter_clone.domain.repository.PostRepository;
import com.efub.twitter_clone.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    /*@Transactional
    public PostResponseDTO getPost(Long id)
    {
        Post post = postRepository.findById().get();

        PostResponseDTO postResponseDTO = PostResponseDTO.builder()
                .contents(post.getContents())
                .post_date(post.getPost_date())
                .nickname(post.getUser().getNickname())
        return postResponseDTO;
    }*/
    @Transactional
    public static PostResponseDTO savePost(PostRequestDTO postRequestDTO)
    {
    }

/*
    @Transactional
    public void deletePost(Long post_id){ //로그인 기능이 없기 때문에 모두가 삭제 가능
        postRepository.deleteById(post_id);
    }

    public PostResponseDTO buildPostDTO(Post post) {
        return new PostResponseDTO(post);
    }

*/
}
