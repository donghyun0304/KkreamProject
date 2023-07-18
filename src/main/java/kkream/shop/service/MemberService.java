package kkream.shop.service;

import kkream.shop.domain.Member;
import kkream.shop.exception.MyNotFoundMemberException;
import kkream.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findById(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MyNotFoundMemberException("회원을 찾을 수 없음"));
    }

    public Member findByEmail(String email){
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new MyNotFoundMemberException("회원을 찾을 수 없음"));
    }

    public List<Member> findAll(){
        if(memberRepository.findAll() != null){
            return memberRepository.findAll();
        } else {
            throw new MyNotFoundMemberException("회원을 찾을 수 없음");
        }
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }
    
    public void update(){
        //매개변수랑 로직은 컨트롤러 로직 짤때 다시 짜야함
    }

    public void delete(Long memberId){
        memberRepository.delete(memberId);
    }
}
