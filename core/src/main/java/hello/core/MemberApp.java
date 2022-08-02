package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //모든 객체를 관리해줌 (Bean 이런것들)
        //AppConfig 에 있는 환경정보 설정을 가지고 스프링이 @Bean 을 스프링 컨테이너에 집어넣어서 관리해줌

        //AppConfig 에 등록되어있는 [메서드 이름, 타입] 그대로 가져와야함 함.
        //스프링 컨테이너에서 꺼낼 때는 메서드 이름으로 꺼내면 됨
       applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
