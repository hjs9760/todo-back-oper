package com.js.ms.todo.domain.member.application;

import com.js.ms.todo.domain.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberJoinedEvent {

    private Member member;

    public MemberJoinedEvent(Member member) {
        this.member = member;
    }
}
