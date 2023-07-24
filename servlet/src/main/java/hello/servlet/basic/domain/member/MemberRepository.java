package hello.servlet.basic.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 실무에서는 동시성 문제가 생길 수 있기에, HashMap 대신 ConcurrentHashMap, AtomicLong 을 고려해서 사용할 필요가 있음!
public class MemberRepository 
{
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	// 싱글톤으로 생성하기 위해 final 키워드 사용 
	private static final MemberRepository instance = new MemberRepository();
	
	public static MemberRepository getInstance()
	{
		return instance;
	}
	
	private MemberRepository()
	{
		
	}
	
	public Member save(Member member)
	{
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}
	
	public Member findById(Long id)
	{
		return store.get(id);
	}
	
	public List<Member> findAll()
	{
		return new ArrayList<>(store.values());
	}
	
	public void clearStore()
	{
		store.clear();
	}
}
