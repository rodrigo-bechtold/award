package com.rodrigo.award.dtos;

import lombok.Data;

@Data
public class NominationDTO {

    private short year;

    private String title;

    private String studios;

    private String producers;

    private Boolean winner;

    public Boolean getWinner() {
        if(winner == null){
            return false;
        }
        return winner;
    }
}
