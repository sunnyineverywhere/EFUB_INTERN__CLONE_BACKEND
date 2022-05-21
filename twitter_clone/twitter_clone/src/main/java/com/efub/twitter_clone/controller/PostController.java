package com.efub.twitter_clone.controller;


import com.efub.twitter_clone.post.service.PostService;
import com.efub.twitter_clone.controller.dto.PostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;


    @PutMapping("/posts/{id}")
    public String update(@RequestBody PostRequestDTO postDTO){
        postService.updatePost(postDTO);
        return "uploaded";
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable("id") Long id)
    {
        postService.deletePost(id); //postservice에 있는 함수
        return "redirect:/";
    }

}
