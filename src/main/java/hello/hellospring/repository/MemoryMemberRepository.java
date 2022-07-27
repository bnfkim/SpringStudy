package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //회원정보를 저장하기 위해, 키와 값을 저장할 변수
    private static long sequence = 0L; //0,1,2, .. key 값을 생성해주는 역할할

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id값 세팅. 즉 사용자한테는 이름만 입력받음
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null이 반환될 가능성이 있으면 optional로 감싸줌
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //루프를 돌면서 하나를 찾아지면 그것을 반환해줌. 하지만 아무것도 없으면 null로 반환해줌
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear(); //store 을 모두 비움
    }
}
