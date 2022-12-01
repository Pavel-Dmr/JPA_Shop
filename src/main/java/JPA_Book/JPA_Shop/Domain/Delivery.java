package JPA_Book.JPA_Shop.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Embedded
    @Column(name="delivery_address")
    private Address address;

    @Enumerated(EnumType.STRING) // 열거형 주입시 보통 STRING 타입으로 할것
    @Column(name = "delivery_status")
    private Delivery_Status status; // READY , COMP



    @OneToOne(mappedBy = "delivery_key")
    @JoinColumn(name = "order_key")
    private Order order_key;

}
