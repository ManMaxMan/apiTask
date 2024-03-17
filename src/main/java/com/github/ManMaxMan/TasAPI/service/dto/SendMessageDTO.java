package com.github.ManMaxMan.TasAPI.service.dto;

import java.util.Objects;

public class SendMessageDTO {
    private String to;
    private String text;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SendMessageDTO() {
    }

    public SendMessageDTO(String to, String text) {
        this.to = to;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendMessageDTO that = (SendMessageDTO) o;
        return Objects.equals(to, that.to) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, text);
    }

    @Override
    public String toString() {
        return "SendMessageDTO{" +
                "to='" + to + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
