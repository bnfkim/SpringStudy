package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //결과를 꺼내오기 위해서 get 으로 꺼내와 result 에 저장
        Member result = repository.findById(member.getId()).get();

        // 검증 방법 1
        // System.out.println("result = " + (result == member)); // 단순히 같은지 출력

        // 검증 방법 2
        // Assertions.assertEquals(result, member); // result 랑 member 랑 같은지 확인 -> 결과값은 없지만 정상적으로 작동
        // Assertions.assertEquals(result, null); // result 랑 member 랑 같은지 확인 -> 정상적으로 작동되지 않음

        // 검증 방법 3
        //Assertions.assertThat(member).isEqualTo(result);
        assertThat(member).isEqualTo(result); //정적메서드로 하는 방법
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1); //result와 member1이 같은 객체인지 체크
        //같은 객체이면 정상동작, 다른 객체이면 에러발생
    }
}
