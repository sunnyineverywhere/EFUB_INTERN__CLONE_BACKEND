package com.efub.twitter_clone.post.service;

import com.efub.twitter_clone.controller.dto.PostRequestDTO;
import com.efub.twitter_clone.controller.dto.PostResponseDTO;

import com.efub.twitter_clone.domain.entity.Post;
import com.efub.twitter_clone.domain.entity.Member;
import com.efub.twitter_clone.domain.repository.MemberRepository;
import com.efub.twitter_clone.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final MemberRepository memberRepository;

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
        Member member = memberRepository.getByMemberId(postRequestDTO.getMemberId())
                .orElseThrow();//todo: 에러 핸들링 추가
        Post post = Post.builder()
                .member(member)
                .contents(postRequestDTO.getContents())
                .build();
        Post resPost = postRepository.save(post);

        return buildPostDTO(resPost);
    }


    @Transactional
    public Long update(Long id, PostRequestDTO requestDto)
    {
        Post post = postRepository.findById(id) .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        post.update(requestDto.getContents());
        return id;
    }

    @Transactional
    public void deletePost(Long memberId, Long postId){ //로그인 기능이 없기 때문에 모두가 삭제 가능
        //Todo : 로그인 기능 이후 로그인한 유저 적용 필요

        Member member = postRepository.findById(postId).get().getMember();
        if(member.getMemberId().equals(memberId)){
            postRepository.deleteById(postId);
        }


    }





}
