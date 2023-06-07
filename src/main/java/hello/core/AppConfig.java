package hello.core;

import hello.core.discount.FIxDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입 -> MemberServiceImpl 클래스가 더이상 MemberRepository의 구현체에 의존하지 않음
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FIxDiscountPolicy());
    }
}
