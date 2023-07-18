package kkream.shop.repository;

import kkream.shop.domain.Member;
import kkream.shop.exception.MyNotFoundMemberException;
import kkream.shop.repository.dto.UpdateMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberMapper memberMapper;

    public Optional<Member> findById(Long memberId){
        return memberMapper.findById(memberId);
    }


    public Optional<Member> findByEmail(String email){
        return memberMapper.findByEmail(email);
    }

    public List<Member> findAll(){
        return memberMapper.findAll();
    }

    public Member save(Member member){
        memberMapper.save(member);
        Member saveMember = memberMapper.findById(member.getMemberId())
                .orElseThrow(() -> new MyNotFoundMemberException("회원을 찾을 수 없음"));
        log.info("save Member={}", saveMember);
        return saveMember;
    }

    public void update(Long memberId, UpdateMemberDto updateDto){
        memberMapper.update(memberId, updateDto);
    }


    public void delete(Long memberId){
        memberMapper.delete(memberId);
    }

}
