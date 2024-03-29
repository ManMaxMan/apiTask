package com.github.ManMaxMan.TasAPI.core.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StatisticDTO {
    private long users;
    private long activeUsers;
    private long messages;

    @Override
    public String toString() {
        return "Statistic{" +
                "users=" + users +
                ", activeUsers=" + activeUsers +
                ", messages=" + messages +
                '}';
    }
}
