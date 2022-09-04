package com.efub.twitter_clone.service;

import com.efub.twitter_clone.controller.dto.TweetRequestDTO;
import com.efub.twitter_clone.controller.dto.TweetResponseDTO;

import com.efub.twitter_clone.domain.entity.Member;
import com.efub.twitter_clone.domain.entity.Tweet;
import com.efub.twitter_clone.domain.repository.MemberRepository;
import com.efub.twitter_clone.domain.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;

    private final MemberRepository memberRepository;

    public TweetResponseDTO buildTweetDTO(Tweet tweet){
        return new TweetResponseDTO(tweet);
    }

    @Transactional
    public List<TweetResponseDTO> getTweetList(){
        List<Tweet> tweetList = tweetRepository.findAll();
        List<TweetResponseDTO> TweetResponseDTOList = new ArrayList<>();
        for(Tweet tweet: tweetList){
            TweetResponseDTO tweetResponseDTO = buildTweetDTO(tweet);
            TweetResponseDTOList.add(tweetResponseDTO);
        }
        return TweetResponseDTOList;
    }


    @Transactional
    public TweetResponseDTO getTweet(Long tweetId){
        Tweet tweet = tweetRepository.findById(tweetId).get();
        return buildTweetDTO(tweet);
    }

    @Transactional
    public String saveTweet(Member member, TweetRequestDTO tweetRequestDTO)
    {
        System.out.println(member);
        Tweet tweet = Tweet.builder()
                .member(member)
                .contents(tweetRequestDTO.getContents())
                .build();
        tweetRepository.save(tweet);

        return "성공적으로 저장되었습니다.";
    }

    @Transactional
    public String updateTweet(Member member, Long tweetId, TweetRequestDTO requestDto)
    {
        Tweet tweet = tweetRepository.findById(tweetId) .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + tweetId));
        if(tweet.getMember().equals(member)){
            tweet.update(requestDto.getContents());
            return "성공적으로 변경되었습니다.";
        }
        else{
            return "잘못된 접근입니다.";
        }
    }

    @Transactional
    public String deleteTweet(Member member, Long tweetId){
        //Todo : 로그인 기능 이후 로그인한 유저 적용 필요
        Tweet tweet = tweetRepository.findById(tweetId).get();
        if(tweet.getMember().equals(member)){
            tweetRepository.deleteById(tweetId);
            return "성공적으로 삭제되었습니다.";
        }
        else{
            return "잘못된 접근입니다.";
        }

    }





}
