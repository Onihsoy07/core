package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    private final RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10%  할인")
    void discount() {
        //given
        Member member = new Member(1L, "member1", Grade.VIP);

        //when
        int price = 10000;
        int discount = discountPolicy.discount(member, price);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 아닐때 할인 안됨")
    void noDiscount() {
        //given
        Member member = new Member(1L, "member1", Grade.BASIC);

        //when
        int price = 10000;
        int discount = discountPolicy.discount(member, price);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}