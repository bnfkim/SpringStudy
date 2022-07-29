package hello.hellospring.domain;

import javax.persistence.*;

@Entity //JPA가 관리하는 Entity 라는 것을 알려줌
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //시스템이 저장하는 id

    @Column(name = "username") //데이터베이스에 있는 칼럼 명을 바꿔서 인식해줌
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
