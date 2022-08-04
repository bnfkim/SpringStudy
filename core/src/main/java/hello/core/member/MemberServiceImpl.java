package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 내 Bean이 자동으로 등록되지만, 의존성 주입은 안 되기 때문에 Autowired 가 필요함
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired //자동으로 의존성 주입을 해줌 (ac.getBean(MemberRepository.class)와 같은 기능)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
