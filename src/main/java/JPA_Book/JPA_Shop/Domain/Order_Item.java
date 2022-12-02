package JPA_Book.JPA_Shop.Domain;

import JPA_Book.JPA_Shop.Domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Order_Item {
// 특정 상품을 몇개을 주문했는지, 총합 가격이 얼마인지

    @Id
    @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_key")
    private Item item_key;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_key")
    private Order order_key;

    @Column(name = "order_item_price")
    private int price; // 주문 가격
    @Column(name="order_item_count")
    private int count; // 주문 수량


}
