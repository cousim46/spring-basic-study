package hello.core;

import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
       /* AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();*/

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Long memberId = 1L;

        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order itemA = orderService.createOrder(memberA.getId(), "itemA", 10000);
        System.out.println("itemA.toString() = " + itemA.toString());
        System.out.println("itemA.calculatePrice() = " + itemA.calculatePrice());

    }
}
