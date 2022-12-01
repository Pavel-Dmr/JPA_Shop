package JPA_Book.JPA_Shop.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장 타입을 포함했다는 어노테이션
    private Address address;

//   TODO  관계 형성
    @OneToMany(mappedBy = "member_key") // order 테이블의 member 필드에 맵핑됬다 읽기 전용
    private List<Order> order_list = new ArrayList<>();

}
