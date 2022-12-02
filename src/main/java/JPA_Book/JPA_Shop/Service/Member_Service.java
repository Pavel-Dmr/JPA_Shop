package JPA_Book.JPA_Shop.Service;

import JPA_Book.JPA_Shop.Domain.Member;
import JPA_Book.JPA_Shop.Repository.Member_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // final이 들어간것만 생성자를 만들어 준다
public class Member_Service {

    private final Member_Repository member_repository;




//    회원가입
    @Transactional
    public Long Join(Member member)
    {
        ValidateDuplicate_Member(member);
        member_repository.save(member);
        return member.getId();
    }

    private void ValidateDuplicate_Member(Member member)
    {
        List<Member> find_member  = member_repository.findByName(member.getName());

        if(!find_member.isEmpty())
        {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    @Transactional
    public List<Member> findAll()
    {
        return member_repository.findAll();
    }
    @Transactional
    public Member findOne(Long member_id)
    {
        return member_repository.findOne(member_id);
    }
}
