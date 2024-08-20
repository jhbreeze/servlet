package com.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void save() {
		// given
		Member member = new Member("Hello", 23);

		// when
		Member savedMember = memberRepository.save(member);

		// then
		Member findMember = memberRepository.findById(savedMember.getId());
		assertThat(findMember).isEqualTo(member);
	}

	@Test
	void findAll() {
		// given
		Member member1 = new Member("member1", 23);
		Member member2 = new Member("member2", 25);

		Member savedMember1 = memberRepository.save(member1);
		Member savedMember2 = memberRepository.save(member2);

		// when
		List<Member> findMembers = memberRepository.findAll();

		// then
		assertThat(findMembers.size()).isEqualTo(2);
		assertThat(findMembers).contains(member1, member2);
	}

	@Test
	void getInstance() {
	}

	@Test
	void findById() {
	}

	@Test
	void clearStore() {
	}
}