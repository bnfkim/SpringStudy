package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//스프링이 실행될 때, MemberController 라는 객체를 생성해서 미리 넣어둠. 그리고 스프링이 관리함
@Controller
public class MemberController {
    //스프링 컨테이너에 딱 하나 등록하고 쓰는 방식으로 사용
    private final MemberService memberService;

    @Autowired //memberService 를 스프링이 컨테이너에 있는 memberService 에다가 연결을 시켜줌 -> 의존관계를 주입시켜주는 것
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
