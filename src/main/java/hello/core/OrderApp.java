package hello.core;

import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        MemberService memberService = new MemberServiceImpl();

        Long memberId = 1L;

        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order itemA = orderService.createOrder(memberA.getId(), "itemA", 10000);
        System.out.println("itemA.toString() = " + itemA.toString());
        System.out.println("itemA.calculatePrice() = " + itemA.calculatePrice());

    }
}
