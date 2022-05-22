package com.efub.twitter_clone.controller;


import com.efub.twitter_clone.controller.dto.PostResponseDTO;
import com.efub.twitter_clone.post.service.PostService;
import com.efub.twitter_clone.controller.dto.PostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    // 됨
    @GetMapping("/post")
    public List<PostResponseDTO> postResponseDTOList(){
        return postService.getPosts();
    }

    @PutMapping("/post/{id}") //수정 저장
    public String updatePost(@RequestBody PostRequestDTO postDTO){
        postService.savePost(postDTO);
        return "OK";

    }
    @GetMapping("/post/{id}")
    public String edit(@PathVariable Long id){
        PostResponseDTO postResponseDTO  = postService.getPost(id);
        return "OK";

    }


    @PostMapping("/post")
    // requestbody를 dto형으로 받음
    public String update(@RequestBody PostRequestDTO postRequestDTO)
    {
        postService.savePost(postRequestDTO);
        return "post complete";
    }

    @DeleteMapping("/post/{userNum}/{id}")
    public String deletePost(@PathVariable("userNum") Long userNum , @PathVariable("id") Long id)
    {
        postService.deletePost(userNum, id); //postservice에 있는 함수
        return "delete compelete";
    }


}
