package hello.servlet.domain.member;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;

class MemberRepositoryTest 
{
	MemberRepository memberRepository = MemberRepository.getInstance();
	
	// 테스트 한개가 종료된 이후, 이전 테스트를 깔끔하게 비워주려는 코드 작성 
	@AfterEach
	void afterEach()
	{
		memberRepository.clearStore();
	}
	
	@Test
	void save()
	{
		// given
		Member member = new Member("test", 26);
		
		// when
		Member saveMember = memberRepository.save(member);
		
		// then
		Member findMember = memberRepository.findById(saveMember.getId());
		Assertions.assertThat(findMember).isEqualTo(saveMember);
	}
	
	@Test
	void findAll()
	{
		// given
		Member member1 = new Member("member1", 19);
		Member member2 = new Member("member2", 39);
		
		// when
		memberRepository.save(member1);
		memberRepository.save(member2);
		
		// then
		List<Member> result = memberRepository.findAll();
		Assertions.assertThat(result.size()).isEqualTo(2);
		Assertions.assertThat(result).contains(member1, member2);
		
	}

}
