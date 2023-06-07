package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountpolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { // enum 타입 비교 : ==으로
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
