package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemberServiceImpl memberService = new MemberServiceImpl(new MemoryMemberRepository());
        memberService.join(new Member(1L, "member1", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberService, new FixDiscountPolicy());
        Order item1 = orderService.createOrder(1L, "item1", 10000);
        Assertions.assertThat(item1.getDiscountPrice()).isEqualTo(1000);
    }
}
