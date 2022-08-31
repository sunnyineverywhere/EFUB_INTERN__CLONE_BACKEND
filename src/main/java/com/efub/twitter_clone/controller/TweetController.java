package com.efub.twitter_clone.controller;


import com.efub.twitter_clone.controller.dto.TweetResponseDTO;
import com.efub.twitter_clone.service.TweetService;
import com.efub.twitter_clone.controller.dto.TweetRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {
    private final TweetService tweetService;

    @GetMapping()
    public List<TweetResponseDTO> tweetResponseDTOList(){
        return tweetService.getTweetList();
    }

    @PutMapping("/{tweetId}")
    public String updateTweet(@PathVariable Long tweetId, @RequestBody TweetRequestDTO requestDto)
    { return tweetService.updateTweet(tweetId, requestDto); }

    @GetMapping("/{tweetId}")
    public TweetResponseDTO loadTweet(@PathVariable Long tweetId){
        TweetResponseDTO tweetResponseDTO  = tweetService.getTweet(tweetId);
        return tweetResponseDTO;
    }

    @PostMapping()
    // requestbody를 dto형으로 받음
    public String saveTweet(@RequestBody TweetRequestDTO postRequestDTO)
    {
        return tweetService.saveTweet(postRequestDTO);
    }

    @DeleteMapping("/{tweetId}")
    public String deleteTweet(@PathVariable("tweetId") Long tweetId)
    {
        return tweetService.deleteTweet(tweetId); //postservice에 있는 함수
    }
}
