package kkream.shop.repository;

import kkream.shop.domain.Member;
import kkream.shop.repository.dto.UpdateMemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    Optional<Member> findById(Long memberId);

    Optional<Member> findByEmail(String email);

    List<Member> findAll();

    void save(Member member);

    void update(@Param("memberId") Long memberId, @Param("updateDto") UpdateMemberDto updateDto);

    void delete(Long memberId);

}
