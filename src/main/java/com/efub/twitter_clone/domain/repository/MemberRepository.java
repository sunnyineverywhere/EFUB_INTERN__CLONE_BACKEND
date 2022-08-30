package com.efub.twitter_clone.domain.repository;


import com.efub.twitter_clone.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> getByMemberId(Long memberId);
    //User getByUserNum(Long userNum);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

}
