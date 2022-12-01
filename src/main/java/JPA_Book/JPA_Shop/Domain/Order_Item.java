package JPA_Book.JPA_Shop.Domain;

import JPA_Book.JPA_Shop.Domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Order_Item {

    @Id
    @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    private int order_price; // 주문 가격
    private int order_count; // 주문 수량


}