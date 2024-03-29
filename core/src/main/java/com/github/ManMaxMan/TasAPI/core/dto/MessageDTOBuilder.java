package com.github.ManMaxMan.TasAPI.core.dto;

import java.time.LocalDateTime;

public class MessageDTOBuilder {

    private LocalDateTime localDateTime;
    private String from;
    private String to;
    private String body;

    private MessageDTOBuilder(){}

    public static MessageDTOBuilder builder(){
        return new MessageDTOBuilder();
    }

    public MessageDTOBuilder setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public MessageDTOBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public MessageDTOBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public MessageDTOBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public MessageDTO build (){
        return new MessageDTO(localDateTime, from, to, body);
    }
}
