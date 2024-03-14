package com.github.ManMaxMan.TasAPI.core.dto;

import java.time.LocalDateTime;

public class MessageDTO {

    private LocalDateTime localDateTime;
    private String from;
    private String to;
    private String body;

    public MessageDTO() {
    }

    public MessageDTO(LocalDateTime localDateTime, String from, String to, String body) {
        this.localDateTime = localDateTime;
        this.from = from;
        this.to = to;
        this.body = body;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "localDateTime=" + localDateTime.toString() +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
