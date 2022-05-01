package member;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {
    MemberService service = new MemberServiceImpl();
    @Test
    void join() throws Exception {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        service.join(member);
        Member findMember = service.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}