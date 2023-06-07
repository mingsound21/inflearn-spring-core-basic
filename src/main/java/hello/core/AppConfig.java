package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    // 리팩토링 : 역할 = 메서드 명, 구현 = new로 생성한 객체
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); // 생성자 주입 -> MemberServiceImpl 클래스가 더이상 MemberRepository의 구현체에 의존하지 않음
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static DiscountPolicy discountPolicy() {
        return new FIxDiscountPolicy();
    }
}
