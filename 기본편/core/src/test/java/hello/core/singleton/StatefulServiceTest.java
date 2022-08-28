package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //Thread_A: A 사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //Thread_B: B 사용자 20000원 주문
        int userBPrice = statefulService1.order("userB", 20000);

        //Thread_A : A 사용자 주문 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice); // 사용자 A의 10000원이 출력될 것이라고 예상

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000); //하지만 정작 20000원으로 출력됨

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}