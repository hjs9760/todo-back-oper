package com.js.ms.todo.domain.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional(readOnly = true)
    boolean existsByEmail(String email);

    @Transactional(readOnly = true)
    boolean existsByUserId(String id);

    @Transactional(readOnly = true)
    Member findByEmail(String email);

    Optional<Member> findByOauthIdAndProviderName(String oauthId, String provierName);

    Member findByUserId(String userId);
}
