package com.rodrigo.award.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigInteger;

@Data
public class WinningStreakDTO {

    private String producer;
    private Short previousWin;
    private Short followingWin;
    private Short interval;
    @JsonIgnore
    private Integer ranking;

    public WinningStreakDTO(Object[] columns) {
        this.producer = (String) columns[0];
        this.previousWin = (Short) columns[1];
        this.followingWin = (Short) columns[2];
        this.interval = (Short) columns[3];
        this.ranking = (columns[4] != null) ? ((BigInteger) columns[4]).intValue() : 0;
    }
}
