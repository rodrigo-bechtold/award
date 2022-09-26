package com.rodrigo.award.services;

import com.rodrigo.award.dtos.MinMaxWinningStreakDTO;
import org.springframework.stereotype.Service;

@Service
public interface NominationAnalysisService {

    public MinMaxWinningStreakDTO findMinMaxWinningStreak();
}
