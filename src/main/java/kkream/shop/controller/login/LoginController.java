package kkream.shop.controller.login;

import kkream.shop.controller.dto.LoginRequestDto;
import kkream.shop.domain.Member;
import kkream.shop.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String loginForm(@ModelAttribute("loginDto") LoginRequestDto loginRequestDto){
        return "login/login";
    }

    @PostMapping
    public String login(@Validated @ModelAttribute("loginDto") LoginRequestDto loginRequestDto, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request){

        log.info("loginRequestDto={}", loginRequestDto);

        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Member loginMember = loginService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        log.info("============loginMember={}", loginMember);


        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:" + redirectURL;
    }




}
