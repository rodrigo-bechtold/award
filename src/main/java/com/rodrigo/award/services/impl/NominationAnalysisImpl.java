package com.rodrigo.award.services.impl;

import com.rodrigo.award.dtos.MinMaxWinningStreakDTO;
import com.rodrigo.award.dtos.WinningStreakDTO;
import com.rodrigo.award.services.NominationAnalysisService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class NominationAnalysisImpl implements NominationAnalysisService {

    @PersistenceContext
    private EntityManager entityManager;

    public MinMaxWinningStreakDTO findMinMaxWinningStreak() {
        String queryStr = "select name, nomination_year, next_winning, diff, ranking from (\n" +
                "\tselect  name, nomination_year, next_winning, diff, ranking,\n" +
                "\t\tmin(ranking) over (order by ranking) AS smallerRank, \n" +
                "\t\tmax(ranking) over (order by ranking desc) AS higherRank from (\n" +
                "\t\tselect name, nomination_year, next_winning, diff, dense_rank() over(order by diff) ranking from (\n" +
                "\t\t\tselect prod.name, nom.nomination_year, \n" +
                "\t\t\tlead(nom.nomination_year) over(w) next_winning,\n" +
                "\t\t\tlead(nom.nomination_year) over(w) - nom.nomination_year diff\n" +
                "\t\t\tfrom nomination nom \n" +
                "\t\t\tinner join nominations_producers link on nom.id = link.nomination_id\n" +
                "\t\t\tinner join producer prod on link.producer_id = prod.id\n" +
                "\t\t\twhere nom.winner = true\n" +
                "\t\t\twindow w as (partition by prod.name order by nom.nomination_year)\n" +
                "\t\t) as S1 where diff is not null\n" +
                "\t) as S2\n" +
                ") as S3 where ranking = smallerRank or ranking = higherRank;";
            Query query = entityManager.createNativeQuery(queryStr);
            List resultList = query.getResultList();

            MinMaxWinningStreakDTO minMax = new MinMaxWinningStreakDTO();
            for (Object resultLine : resultList) {
                WinningStreakDTO winningStreakDTO = new WinningStreakDTO((Object[]) resultLine);
                if (winningStreakDTO.getRanking() == 1) {
                    minMax.addMin(winningStreakDTO);
                } else {
                    minMax.addMax(winningStreakDTO);
                }
            }
            return minMax;
    }

}
