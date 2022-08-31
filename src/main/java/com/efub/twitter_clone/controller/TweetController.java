package com.efub.twitter_clone.controller;


import com.efub.twitter_clone.controller.dto.TweetResponseDTO;
import com.efub.twitter_clone.domain.entity.Member;
import com.efub.twitter_clone.global.customAnnotation.AuthMember;
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
    public List<TweetResponseDTO> loadTweetList(@AuthMember Member member){
        // Todo: 타임라인에 유저가 팔로우한 사람들의 게시글 + 팔로우한 사람들이 리트윗한 게시글만 반환
        return tweetService.getTweetList();
    }

    @GetMapping("/{tweetId}")
    public TweetResponseDTO loadTweet(@AuthMember Member member, @PathVariable Long tweetId){
        TweetResponseDTO tweetResponseDTO  = tweetService.getTweet(tweetId);
        return tweetResponseDTO;
    }
    @PostMapping()
    // requestbody를 dto형으로 받음
    public String saveTweet(@AuthMember Member member, @RequestBody TweetRequestDTO postRequestDTO)
    {
        return tweetService.saveTweet(member, postRequestDTO);
    }

    @PutMapping("/{tweetId}")
    public String updateTweet(@AuthMember Member member, @PathVariable Long tweetId, @RequestBody TweetRequestDTO requestDto)
    { return tweetService.updateTweet(member, tweetId, requestDto); }

    @DeleteMapping("/{tweetId}")
    public String deleteTweet(@AuthMember Member member, @PathVariable("tweetId") Long tweetId)
    {
        return tweetService.deleteTweet(member, tweetId);
    }
}
