package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
   // private final DiscountPolicy discountPolicy = new FIxDiscountPolicy(); // DIP 위반 FixDiscountPolicy라는 구현 클래스에 의존
    private DiscountPolicy discountPolicy; // DIP, OCP 해결을 위해서 추상 클래스만 작성 -> 누군가 discountPolicy의 구현체를 대신 주입해줘야함

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일 체계 원칙 잘 지킴 : 할인 정책 변경시 OrderService 부분 고칠 필요 없이 disCountPolicy 부분만 변경하면 됨.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
