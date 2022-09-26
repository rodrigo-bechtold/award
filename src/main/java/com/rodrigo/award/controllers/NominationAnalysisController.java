package com.rodrigo.award.controllers;

import com.rodrigo.award.dtos.MinMaxWinningStreakDTO;
import com.rodrigo.award.services.NominationAnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nomination-analysis")
public class NominationAnalysisController {


    private NominationAnalysisService nominationAnalysisService;

    public NominationAnalysisController(NominationAnalysisService nominationAnalysisService){
        this.nominationAnalysisService = nominationAnalysisService;
    }

    @GetMapping("/min-max-winning-streak")
    public MinMaxWinningStreakDTO getMinMaxWinningStreak() {
        return nominationAnalysisService.findMinMaxWinningStreak();
    }

}
