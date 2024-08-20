package com.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 - 동시성 문제 고려되지 않은 코드
 - 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 - 싱글톤 패턴
 */
public class MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	private static final MemberRepository instance = new MemberRepository(); // 싱글톤 객체 생성

	public static MemberRepository getInstance() {
		return instance;
	}

	private MemberRepository() {} // 싱글톤이니까 생성자 접근제어자 private

	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	public Member findById(long id) {
		return store.get(id);
	}

	public List<Member> findAll() {
		return new ArrayList<>(store.values()); // store의 모든 값을 새로운 arrayList에 담아서 반환 : 왜냐? arrayList를 조작해도 store의 values에 영향 없음
	}

	public void clearStore() {
		store.clear();
	}
}
