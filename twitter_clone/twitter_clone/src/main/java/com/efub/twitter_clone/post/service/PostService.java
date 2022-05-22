package com.efub.twitter_clone.post.service;

import com.efub.twitter_clone.controller.dto.PostRequestDTO;
import com.efub.twitter_clone.controller.dto.PostResponseDTO;

import com.efub.twitter_clone.domain.entity.Post;
import com.efub.twitter_clone.domain.entity.User;
import com.efub.twitter_clone.domain.repository.PostRepository;
import com.efub.twitter_clone.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final UserRepository userRepository;

    public PostResponseDTO buildPostDTO(Post post){
        return new PostResponseDTO(post);
    }

    @Transactional
    public List<PostResponseDTO> getPosts(){
        List<Post> postList = postRepository.findAll();
        List<PostResponseDTO> postResponseDTOList = new ArrayList<>();
        for(Post post: postList){
            PostResponseDTO postResponseDTO = buildPostDTO(post);
            postResponseDTOList.add(postResponseDTO);
        }
        return postResponseDTOList;
    }


    @Transactional
    public PostResponseDTO getPost(Long postId){
        Post post = postRepository.findById(postId).get();
        return buildPostDTO(post);
    }

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

    @Transactional
    public void deletePost(Long userNum, Long postId){ //로그인 기능이 없기 때문에 모두가 삭제 가능

        User user = postRepository.findById(postId).get().getUser();
        if(user.getUserNum() == userNum){
            postRepository.deleteById(postId);
        }


    }





}
