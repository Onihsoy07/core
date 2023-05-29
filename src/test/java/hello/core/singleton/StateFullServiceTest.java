package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StateFullServiceTest {

    @Test
    @DisplayName("싱글톤 주의")
    void statefullServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFullService stateFullService1 = ac.getBean("stateFullService", StateFullService.class);
        StateFullService stateFullService2 = ac.getBean("stateFullService", StateFullService.class);

        int price1 = stateFullService1.order("user1", 10000);
        int price2 = stateFullService1.order("user2", 20000);

        // StateFullService의 price가 공유되므로 문제됨
//        int price = stateFullService1.getPrice();
//        System.out.println("price : " + price);

        assertThat(price1).isEqualTo(10000);
        assertThat(price2).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StateFullService stateFullService() {
            return new StateFullService();
        }
    }
}