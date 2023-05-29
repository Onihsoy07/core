package hello.core.singleton;

import hello.core.config.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("Congifuration 싱글톤 확인")
    void configurationSingletonTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean(OrderService.class);
        MemberService memberService = ac.getBean(MemberService.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        MemberRepository memberRepository3 = ac.getBean(MemberRepository.class);

        System.out.println("memberService의 memberRepository : " + memberRepository1);
        System.out.println("orderService의 memberRepository : " + memberRepository2);
        System.out.println("memberRepository : " + memberRepository3);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2).isSameAs(memberRepository3);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean : " + bean.getClass());
    }
}
