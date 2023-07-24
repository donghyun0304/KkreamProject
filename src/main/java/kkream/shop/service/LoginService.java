package kkream.shop.service;

import kkream.shop.domain.Member;
import kkream.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String email, String password) {
        return memberRepository.findByEmail(email)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);  //예외 터트리지 않고 loginController에서 validation 처리
//                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호 확인"));
    }
}
