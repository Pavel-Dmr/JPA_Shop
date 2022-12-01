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

    @Column(name = "order_date")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private Order_Status status; // 주문상태 [ORDER, CANCEL]

//   TODO  관계 형성

    @ManyToOne
    @JoinColumn(name="member_key")
    private Member member_key;

    @OneToMany(mappedBy = "order_key")
    private List<Order_Item> order_item_list =  new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "delivery_key")
    private Delivery delivery_key;

}
