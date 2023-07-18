package kkream.shop.repository;

import kkream.shop.domain.Member;
import kkream.shop.exception.MyNotFoundMemberException;
import kkream.shop.repository.dto.UpdateMemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 존재")
    void save(){
        //given
        Member member = new Member("bbbb@naver.com", "1234", "010-3333-3333",
                260, 'Y', 'Y', "이지금", "지금", "일반");
        memberRepository.save(member);
        //when
        Member findMember = memberRepository.findById(member.getMemberId())
                .orElseThrow(() -> new MyNotFoundMemberException("회원을 찾을 수 없음"));
        //then
        assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
    }

    @Test
    @DisplayName("예외 확인")
    void findById(){
        assertThatThrownBy(() -> memberRepository.findById(0L)
                .orElseThrow(() -> new MyNotFoundMemberException("회원을 찾을 수 없음")))
                .isInstanceOf(MyNotFoundMemberException.class)
                .hasMessageContaining("회원을 찾을 수 없음");
    }

    @Test
    void findByEmail(){
        //given
        Member member = new Member("bbbb@naver.com", "1234", "010-3333-3333",
                260, 'Y', 'Y', "이지금", "지금", "일반");
        memberRepository.save(member);
        //when
        Member findMember = memberRepository.findByEmail(member.getEmail())
                .orElseThrow(() -> new MyNotFoundMemberException("회원을 찾을 수 없음"));
        //then
        assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("aaaa@naver.com", "1234", "010-3333-3333",
                260, 'Y', 'Y', "홍길동", "지금", "일반");
        Member member2 = new Member("bbbb@naver.com", "1234", "010-3333-3333",
                260, 'Y', 'Y', "이지금", "지금", "일반");
        Member member3 = new Member("cccc@naver.com", "1234", "010-3333-3333",
                260, 'Y', 'Y', "김신영", "지금", "일반");

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        //when
        List<Member> members = memberRepository.findAll();
        //then
        assertThat(members.size()).isEqualTo(3);
    }

    @Test
    void update(){
        //given
        Member member = new Member("bbbb@naver.com", "1234", "010-3333-3333",
                260, 'Y', 'Y', "이지금", "지금", "일반");
        memberRepository.save(member);
        //when
        UpdateMemberDto updateMemberDto = new UpdateMemberDto("0000", "010-1234-1234",
                220, 'N', 'N', "a",
                "이모래", "테스트입니다", "골드");

        memberRepository.update(member.getMemberId(), updateMemberDto);
        //then
        Member updateMember = memberRepository.findById(member.getMemberId()).get();

        assertThat(updateMemberDto.getPassword()).isEqualTo(updateMember.getPassword());
        assertThat(updateMemberDto.getPhoneNumber()).isEqualTo(updateMember.getPhoneNumber());
        assertThat(updateMemberDto.getShoeSize()).isEqualTo(updateMember.getShoeSize());
        assertThat(updateMemberDto.getAdMessage()).isEqualTo(updateMember.getAdMessage());
        assertThat(updateMemberDto.getAdEmail()).isEqualTo(updateMember.getAdEmail());
        assertThat(updateMemberDto.getProfileFile()).isEqualTo(updateMember.getProfileFile());
        assertThat(updateMemberDto.getNickName()).isEqualTo(updateMember.getNickName());
        assertThat(updateMemberDto.getIntroduction()).isEqualTo(updateMember.getIntroduction());
        assertThat(updateMemberDto.getGrade()).isEqualTo(updateMember.getGrade());
    }

    @Test
    void delete(){
        //given
        Member member = new Member("bbbb@naver.com", "1234", "010-3333-3333",
                260, 'Y', 'Y', "이지금", "지금", "일반");
        memberRepository.save(member);
        //when
        memberRepository.delete(member.getMemberId());
        //then
        char deletedStatus = memberRepository.findById(member.getMemberId())
                .get().getDeletedStatus();
        assertThat(deletedStatus).isEqualTo('Y');
    }







}
