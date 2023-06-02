package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberService memberService;
    private final  DiscountPolicy discountPolicy;

    //타입 매칭이 2개 이상이면 파라메타 명으로 한번 더 조회함
//    public OrderServiceImpl(MemberService memberService, DiscountPolicy rateDiscountPolicy) {
//        this.memberService = memberService;
//        this.discountPolicy = rateDiscountPolicy;
//    }

    //@Qualifier명으로 빈 찾기, 없으면 스프링 빈 이름으로 한번 더 조회함
    //@Qualifier는 @Qualifier를 찾을 때만 쓰기(권장)
//    public OrderServiceImpl(MemberService memberService, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.memberService = memberService;
//        this.discountPolicy = discountPolicy;
//    }

    //타입 중복 시 @Primary 우선 빈 주입(현제 FixDiscountPolicy에 달았음)
//    public OrderServiceImpl(MemberService memberService, DiscountPolicy discountPolicy) {
//        this.memberService = memberService;
//        this.discountPolicy = discountPolicy;
//    }

    //어노테이션 만들어서 넣기
        public OrderServiceImpl(MemberService memberService, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberService = memberService;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberService.findMember(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //싱글톤 확인 테스트용
    public MemberRepository getMemberRepository() {
        return memberService.getMemberRepository();
    }

}
