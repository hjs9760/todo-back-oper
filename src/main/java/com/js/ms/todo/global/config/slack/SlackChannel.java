package com.js.ms.todo.global.config.slack;

import lombok.Getter;

@Getter
public enum SlackChannel {

    CHANNEL_EXCEPTION("https://hoxx.slack.com/archives/C01Q76262UW"),
    CHANNEL_MEMBER("https://hoxx.slack.com/archives/C01Q762BRT8");

    private String url;

    SlackChannel(String url) {
        this.url = url;
    }
}
