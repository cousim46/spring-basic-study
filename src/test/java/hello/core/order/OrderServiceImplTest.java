package hello.core.order;

import member.Grade;
import member.Member;
import member.MemberService;
import member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() throws Exception {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        //when
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        //then
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }
}