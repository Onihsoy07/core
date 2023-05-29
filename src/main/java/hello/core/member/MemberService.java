package hello.core.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

    //싱글톤 확인 테스트용
    MemberRepository getMemberRepository();
}
