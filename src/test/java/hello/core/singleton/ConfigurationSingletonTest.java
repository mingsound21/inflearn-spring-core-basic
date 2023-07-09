package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() throws Exception {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //when
        // 원래는 구체타입으로 꺼내는 것은 좋지 않다. 지금은 각 Impl에 만들어둔 getMemberRepository함수 사용을 위해서
        MemberServiceImpl memberServiceImpl = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderServiceImpl = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository3 = ac.getBean(MemberRepository.class);

        //then
        MemberRepository memberRepository1 = memberServiceImpl.getMemberRepository();
        MemberRepository memberRepository2 = orderServiceImpl.getMemberRepository();

        // 3개의 memberRepository의 인스턴스 객체 주소 값이 같다.
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository3);

        Assertions.assertThat(memberServiceImpl.getMemberRepository()).isSameAs(memberRepository3);
        Assertions.assertThat(orderServiceImpl.getMemberRepository()).isSameAs(memberRepository3);
    }

    @Test
    void configurationDeep() throws Exception {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);


        //when
        System.out.println("bean.getClass() = " + bean.getClass());// bean.getClass() = class hello.core.AppConfig$$SpringCGLIB$$0
        // 순수한 클래스인 경우 : class hello.core.AppConfig
        // xxxCGLIB : 내가 만든 클래스가 아니라 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록. 임의의 다른 클래스가 싱글톤이 보장되도록해준다.

        //then
    }
}
