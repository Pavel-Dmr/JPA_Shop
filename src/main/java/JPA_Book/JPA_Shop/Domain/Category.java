package JPA_Book.JPA_Shop.Domain;


import JPA_Book.JPA_Shop.Domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue()
    @Column(name = "category_id")
    private Long id;

    @Column(name="category_name")
    private String name;

    //중간 테이블 맵핑
    // 일대다 다대일을 연결하는 중간테이블이 필요함
    @OneToMany(mappedBy = "category_key")
    private List<Item_And_Category> IC_list = new ArrayList<>();

//    주항목
    @ManyToOne
    @JoinColumn(name = "parent_key")
    private Category parent_key;

    //세부 항목
    @OneToMany(mappedBy = "parent_key")
    private List<Category> child_key = new ArrayList<>();

}
