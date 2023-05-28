package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private final MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member1 = new Member(1L, "member1", Grade.VIP);

        //when
        memberService.join(member1);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member1).isEqualTo(findMember);
    }

}