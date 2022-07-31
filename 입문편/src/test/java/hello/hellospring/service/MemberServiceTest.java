package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach //메소드 전 마다 실행
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore(); //돌 때 마다 다 해당 메서드를 계속 실행해줌
    }

    @Test
    void 회원가입() {
        //given -> 이게 주어졌을 때 -> 새로운 멤버객체 생성 및 이름 세팅
        Member member = new Member();
        member.setName("hello");

        //when -> 이런 상황일 때
        Long saveId = memberService.join(member); // 이름으로 회원가입 후 id 반환받음

        //then -> 이런 결과가 나와야해
        Member findMember = memberService.findOne(saveId).get(); //반환 받은 id로
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        //then

    }

   @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}