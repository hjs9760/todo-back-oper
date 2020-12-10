package com.js.ms.todo.domain.member.domain;

import com.js.ms.todo.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
