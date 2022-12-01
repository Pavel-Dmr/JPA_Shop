package JPA_Book.JPA_Shop.Domain.Item;

import JPA_Book.JPA_Shop.Domain.Category;
import JPA_Book.JPA_Shop.Domain.Item_And_Category;
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

    @Column(name="item_name")
    private String name;

    @Column(name="item_price")
    private int price;

    @Column(name="item_stock_quantity")
    private int stock_quantity;

//    TODO 관계 형성

//    1다대 다대1일을 연결하는 중간 테이블이 필요함
    @OneToMany(mappedBy = "item_key")// 중간 테이블 맵핑
    private List<Item_And_Category> IC_list = new ArrayList<>();

}
