package hello.core.lifeCicle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//스프링 빈 라이프 사이클
//스프링 컨테이너 생성 -> 스프링 빈 생성(생성자 주입) -> 의존관계 주입(setter, 필드 주입) -> 초기화 콜백(스프링 빈 등록 완료 알림) -> 사용 -> 소멸 전 콜백 -> 스프링 종료
public class BeanLifeCycle {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient networkClient = ac.getBean(NetworkClient.class);
        //ApplicationContext에는 close없음 ConfigurableApplicationContext or AnnotationConfigApplicationContext로 가능
        //AnnotationConfigApplicationContext가 ConfigurableApplicationContext 상속
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello.core.test");
            return networkClient;
        }
    }
}
