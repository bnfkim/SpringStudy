package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//스프링이 실행될 때, MemberController 라는 객체를 생성해서 미리 넣어둠. 그리고 스프링이 관리함
@Controller
public class MemberController {
    //스프링 컨테이너에 딱 하나 등록하고 쓰는 방식으로 사용
    private final MemberService memberService;

    // DI 방식 3가지
    // 1. 생성자 방식 (추천)
    @Autowired //memberService 를 스프링이 컨테이너에 있는 memberService 에다가 연결을 시켜줌 -> 의존관계를 주입시켜주는 것
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // 2. 필드 방식
    //@Autowired private final MemberService memberService;

    // 3. setter 방식
    // @Autowired
    // public setMemberService(MemberService memberService){
    //     this.memberService = memberService;
    // }

    // GetMapping 이냐 PostMapping 이냐에 따라 역할이 달라짐
    // Get -> 데이터를 조회할 때 / Post -> 데이터를 등록할 때

    @GetMapping(value = "/members/new")
    public String createForm(){
        return "members/createMemberForm"; //-> 템플릿에서 해당 이름을 찾음
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
