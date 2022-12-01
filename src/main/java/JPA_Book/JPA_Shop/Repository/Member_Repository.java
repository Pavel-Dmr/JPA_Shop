package JPA_Book.JPA_Shop.Repository;

import JPA_Book.JPA_Shop.Domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class Member_Repository {

    @PersistenceContext
    EntityManager em;

    public Long save(Member member)
    {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id)
    {
        return em.find(Member.class,id);
    }
}
