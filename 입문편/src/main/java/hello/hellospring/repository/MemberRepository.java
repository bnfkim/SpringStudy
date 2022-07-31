package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//4가지 기능 만들기
public interface MemberRepository {
    Member save(Member member); //저장소에 id가 저장되는 기능
    //id와 name을 찾아오는 기능
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    //지금까지 저장된 회원들의 리스트를 출력
    List<Member> findAll();
}
