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
    @Column(name="category_id")
    private Long id;
    private String name;

    //중간 테이블 맵핑
    // 일대다 다대일을 연결하는 중간테이블이 필요함
    @ManyToMany
    @JoinTable(name="category_item",joinColumns = @JoinColumn(name = "category_id"),inverseJoinColumns = @JoinColumn(name="item_id"))
            private List<Item> item_list = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

}
