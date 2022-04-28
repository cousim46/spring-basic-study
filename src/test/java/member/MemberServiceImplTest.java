package member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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