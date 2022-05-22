package com.efub.twitter_clone.post.service;

import com.efub.twitter_clone.controller.dto.PostRequestDTO;
import com.efub.twitter_clone.controller.dto.PostResponseDTO;

import com.efub.twitter_clone.domain.entity.Post;
import com.efub.twitter_clone.domain.entity.User;
import com.efub.twitter_clone.domain.repository.PostRepository;
import com.efub.twitter_clone.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponseDTO buildPostDTO(Post post){
        return new PostResponseDTO(post);
    }


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
    public PostResponseDTO savePost(PostRequestDTO postRequestDTO)
    {
        User user = userRepository.getByUserNum(postRequestDTO.getUserNum());
        Post post = Post.builder()
                .user(user)
                .contents(postRequestDTO.getContents())
                .build();
        Post resPost = postRepository.save(post);
        return buildPostDTO(resPost);
    }


    /*
    @Transactional
    public List<PostResponseDTO> getPosts(){
        List<Post> postList = postRepository.findAll();

    }

*/

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
