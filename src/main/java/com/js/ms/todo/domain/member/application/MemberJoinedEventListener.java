package com.js.ms.todo.domain.member.application;

import com.js.ms.todo.global.config.slack.SlackChannel;
import com.js.ms.todo.global.config.slack.SlackMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MemberJoinedEventListener {

    private final SlackMessage slackMessage;

    @EventListener
    public void handle(com.js.ms.todo.domain.member.application.MemberJoinedEvent memberJoinedEvent) {
        String memberName = memberJoinedEvent.getMember().getName();
        slackMessage.sendSlackMessage(SlackChannel.CHANNEL_MEMBER, memberName + " 님이 todo에 회원이 되었습니다.");
    }
}
