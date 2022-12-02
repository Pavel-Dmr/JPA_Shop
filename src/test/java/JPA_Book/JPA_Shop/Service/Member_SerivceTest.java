package JPA_Book.JPA_Shop.Service;

import JPA_Book.JPA_Shop.Domain.Member;
import JPA_Book.JPA_Shop.Repository.Member_Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@Service
public class Member_SerivceTest {

    @Autowired
    Member_Service member_service;
    @Autowired
    Member_Repository member_repository;

    @Test
    public void 회원가입() throws Exception
    {
//        준비
        Member member = new Member();
        member.setName("kim");

//        구현
        Long save_id = member_service.Join(member);

//        검증
        assertEquals(member,member_repository.findOne(save_id));
    }

    @Test
    public void 중복회원_예외() throws Exception
    {
//        준비
        Member member_01 = new Member();
        member_01.setName("Kim");
        Member member_02 = new Member();
        member_02.setName("Kim");
//        구현
        member_service.Join(member_01);

//        검증
        assertThrows(IllegalStateException.class, () -> {
            member_service.Join(member_02);
        }, "이미 존재하는 회원입니다");
    }

}
