package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach // 각 테스트 전에 우선적으로 무조건 실행되는 함수
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @DisplayName("회원이 1개의 주문을 한다.")
    @Test
    void createOrder() throws Exception{
        //given

        // 회원 생성 & 등록
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        // 회원이 1개의 주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000); // VIP 등급인 회원은 정액할인 정책에 따라서 1000원 할인
    }


}