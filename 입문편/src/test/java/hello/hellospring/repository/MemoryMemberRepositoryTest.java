package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    //MemberRepository repository = new MemoryMemberRepository();
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    //메서드가 끝날 때 마다 어떠한 행동을 취하는 콜백 메서드
    public void afterEach(){
        repository.clearStore();
    }

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

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2); //찾은 갯수가 맞는지 체크크
   }
}
