package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // 회원 생성 & 등록
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 회원이 1개의 주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);// Order 객체의 toString
        System.out.println("order.calculatePrice() = " + order.calculatePrice()); // 할인까지 적용되어 유저가 내야하는 가격

    }
}
