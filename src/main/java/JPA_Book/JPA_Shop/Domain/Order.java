package JPA_Book.JPA_Shop.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="order_list")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") // 외래키가 member_id
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<Order_Item> order_item_list =  new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime order_date;

    @Enumerated(EnumType.STRING)
    private Order_Status status; // 주문상태 [ORDER, CANCEL]
}
