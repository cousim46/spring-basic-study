package hello.core.discount;

import member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
