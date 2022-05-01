package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        memberService = new AppConfig().memberService();
        orderService = new AppConfig().orderService();
    }

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