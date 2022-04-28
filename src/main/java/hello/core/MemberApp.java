package hello.core;

import member.Grade;
import member.Member;
import member.MemberService;
import member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        System.out.println("member = " + member);
        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember);
        
    }
}
