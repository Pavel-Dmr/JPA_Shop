package JPA_Book.JPA_Shop.Repository;

import JPA_Book.JPA_Shop.Domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
class Member_RepositoryTest {

    @Autowired
    Member_Repository member_repository;

    @Test
    @Transactional
    @Rollback(false)
    void save() {
        Member member = new Member();
        member.setName("Member_A");
        Long save_id = member_repository.save(member);
        Member find_member = member_repository.findOne(save_id);
        Assertions.assertThat(find_member.getId()).isEqualTo(member.getId());
    }


    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        Member member = new Member();
        member.setName("memberA");
        Long savedId = member_repository.save(member);
        Member findMember = member_repository.findOne(savedId);
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());

        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
    }


    @Test
    void find() {

    }
}