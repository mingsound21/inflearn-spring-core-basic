package hello.core.member;

import org.assertj.core.api.Assertions; // junit.Jupiter.api도 있음
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember); // member 객체와 findMember 객체가 같은지 검사
        // isSameAs : 메모리상 같은 객체를 가리키는지 비교 (주소 비교)
        // isEqualTo : 객체가 같은 값을 가지고 있는지 비교 (값 비교)
    }

}
