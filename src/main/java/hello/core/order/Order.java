package hello.core.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Order {
    private Long memberId;// 주문한 유저의 Id
    private String itemName; // 주문한 상품 이름
    private int itemPrice; // 주문한 상품 가격
    private int discountPrice; // 할인 되는 가격

    // 할인까지 적용된 금액
    public int calculatePrice(){
        return itemPrice - discountPrice;
    }

    // 객체 출력시 toString함수로 지정한 문자열이 출력됨
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
