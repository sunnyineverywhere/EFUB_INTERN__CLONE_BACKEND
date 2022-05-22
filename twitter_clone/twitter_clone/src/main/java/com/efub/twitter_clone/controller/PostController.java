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


    @GetMapping("/post/{id}")
    public String getPost(@PathVariable("id") Long id)
    {
        return "get complete";
    }


    /*@GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        PostRequestDTO postRequestDTO = postService.getPost(id);//게시물을 가져온다.
        model.addAttribute("postRequestDTO", postRequestDTO);
        return "board/update.html"; //업데이트 화면으로 이동
    }*/

    @PostMapping("/post")
    public String update(PostRequestDTO postRequestDTO)
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
