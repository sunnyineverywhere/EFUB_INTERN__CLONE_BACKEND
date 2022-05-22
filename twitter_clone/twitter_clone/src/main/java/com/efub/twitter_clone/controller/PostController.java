package com.efub.twitter_clone.controller;


import com.efub.twitter_clone.controller.dto.PostResponseDTO;
import com.efub.twitter_clone.post.service.PostService;
import com.efub.twitter_clone.controller.dto.PostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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

    /*
    @GetMapping("/post/{user_id}/{post_id}")
    public PostResponseDTO postResponseDTO(@PathVariable("user_id") String userId, @PathVariable("post_id") Long postId){

    }
    */


    @PostMapping("/post")
    // requestbody를 dto형으로 받음
    public String update(@RequestBody PostRequestDTO postRequestDTO)
    {
        postService.savePost(postRequestDTO);
        return "post complete";
    }


    /*
    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable("id") Long id)
    {
        postService.deletePost(id); //postservice에 있는 함수
        return "redirect:/";
    }


     */

}
