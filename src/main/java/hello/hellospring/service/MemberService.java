package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //회원 서비스를 만들기 위해서는 회원 레포지토리가 있어야함
    private final MemberRepository memberRepository;

    // DI 방식
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){
        // Optional<Member> result = memberRepository.findByName(member.getName()); //cmd + option + v, ctrl + alt + v = 변수추출
        // result.ifPresent(m -> {
        //     throw new IllegalStateException("이미 존재하는 회원입니다");
        // }); //만약 값이 있으면 던지도록 해
        // null의 가능성이 있으면 Optional 을 사용 -> Optional 감싸면 사용할 수 있는 메서드들이 잇음
        // get 메서드를 통해 바로 가져올 수도 있으나 권장하지는 않음
        // elseGet 메서드를 사용해서 있으면 가져오고, 없으면 다른 메서드를 실행하도록 하는 방법도 있음

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // 멤버 저장
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
