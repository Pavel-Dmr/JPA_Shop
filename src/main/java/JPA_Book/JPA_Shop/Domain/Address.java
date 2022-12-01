package JPA_Book.JPA_Shop.Domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 어딘가에 내장 될 수 있다.
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
