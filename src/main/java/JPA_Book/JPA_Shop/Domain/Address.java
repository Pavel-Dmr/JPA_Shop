package JPA_Book.JPA_Shop.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 어딘가에 내장 될 수 있다.
@Getter
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;


}

// 식별자가 없고 값만 있으므로 변경시 추적 불가
// Setter 제거
// 생성자 값을 모두 초기화해서 변경 불가능한 클래스를 만든다
// public 보다는 protected로 설정하여 좀 더 안전하게 한다
