package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    //싱글톤 패턴을 하기 위해 생성자를 막아놔서 new가 아닌 getInstance 방식으로 사용
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given (이런게 주어졌을 때)
        Member member = new Member("hello", 20);

        //when (이런게 실행되었을 때)
        Member saveMember = memberRepository.save(member);

        //then (이런 결과가 나와야 해)
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        //given (이런게 주어졌을 때)
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when (이런게 실행되었을 때)
        List<Member> result = memberRepository.findAll();

        //then (이런 결과가 나와야 해)
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2); //result 안에 객체가 있는지
    }

}