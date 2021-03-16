package com.js.ms.todo.global.config.slack;

import lombok.Getter;

@Getter
public enum SlackChannel {

    CHANNEL_EXCEPTION("https://hooks.slack.com/services/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"),
    CHANNEL_MEMBER("https://hooks.slack.com/services/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");

    private String url;

    SlackChannel(String url) {
        this.url = url;
    }
}
