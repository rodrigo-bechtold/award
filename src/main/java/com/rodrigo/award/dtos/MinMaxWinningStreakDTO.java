package com.rodrigo.award.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MinMaxWinningStreakDTO {

    List<WinningStreakDTO> min = new ArrayList<>();
    List<WinningStreakDTO> max = new ArrayList<>();

    public void addMin(WinningStreakDTO winStreak) {
        min.add(winStreak);
    }

    public void addMax(WinningStreakDTO winStreak) {
        max.add(winStreak);
    }
}
