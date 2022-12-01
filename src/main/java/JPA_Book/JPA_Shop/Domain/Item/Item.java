package JPA_Book.JPA_Shop.Domain.Item;

import JPA_Book.JPA_Shop.Domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 테이블 하나로 묶음
@DiscriminatorColumn(name ="dtype") // 하나로 묶인 테이블을 dtype의 분류
@Getter
@Setter
public abstract class Item {
    //상속관계 전략을 지정 - 싱글 테이블
    //

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;

    private int price;
    private int stock_quantity;

    @ManyToMany(mappedBy = "item_list")// 중간 테이블 맵핑
//    1다대 다대1일을 연결하는 중간 테이블이 필요함
    private List<Category> category_list = new ArrayList<>();

}
