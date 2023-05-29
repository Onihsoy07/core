package hello.core.beanFind;

import hello.core.config.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름 조회")
    void findBeanName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService : " + memberService);
        System.out.println("memberService Class : " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService : " + memberService);
        System.out.println("memberService Class : " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 구체 타입으로 조회")
    void findBeanName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        System.out.println("memberService : " + memberService);
        System.out.println("memberService Class : " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름 조회 X")
    void  findBeanByNameX() {
//        MemberService memberService = ac.getBean("xx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () ->  ac.getBean("xx", MemberService.class));
    }
    
}
