package JPA_Book.JPA_Shop.Domain;

import JPA_Book.JPA_Shop.Domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Item_And_Category {

    @Id
    @GeneratedValue()
    @Column(name ="IC_id")
    private Long IC_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_key")
    private Item item_key;

    @ManyToOne
    @JoinColumn(name = "category_key")
    private Category category_key;
}
