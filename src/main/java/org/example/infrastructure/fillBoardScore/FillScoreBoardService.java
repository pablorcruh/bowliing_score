package org.example.infrastructure.fillBoardScore;

import org.example.domain.LastSlot;
import org.example.domain.RegularSlot;
import org.example.domain.ScoreBoardRow;
import org.example.domain.services.IFillScoreBoardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FillScoreBoardService implements IFillScoreBoardService {
    @Override
    public List<ScoreBoardRow> fillScoreBoardRow(HashMap<String, Integer> scoreHashMap, Set<String> players) {
        List<ScoreBoardRow> result = new ArrayList<>();
        for (String player : players) {
            ScoreBoardRow userScoreBoard = new ScoreBoardRow();
            userScoreBoard.setPlayerName(player);
            for(int i = 1; i <= 10; i++){
                LastSlot lastSlot = new LastSlot();
                if(i < 10){
                    RegularSlot regularSlot = new RegularSlot();
                    Integer firstShot = scoreHashMap.get(player+"-"+i+"-"+1);
                    Integer secondShot = scoreHashMap.get(player+"-"+i+"-"+2);
                    regularSlot.setFirstShot(firstShot != null ? firstShot :0);
                    regularSlot.setSecondShot(secondShot != null ? secondShot: 0);
                    regularSlot.setPositionSlot(i);
                    userScoreBoard.addRegularSlot(regularSlot);
                }else{
                    Integer firstShot = scoreHashMap.get(player+"-"+i+"-"+1);
                    Integer secondShot = scoreHashMap.get(player+"-"+i+"-"+2);
                    Integer thirdShot = scoreHashMap.get(player+"-"+i+"-"+3);
                    lastSlot.setFirstShot(firstShot != null ? firstShot :0);
                    lastSlot.setSecondShot(secondShot != null ? secondShot: 0);
                    lastSlot.setThirdShot(thirdShot != null ? thirdShot: 0);
                    userScoreBoard.setLastSlot(lastSlot);
                }
            }
            result.add(userScoreBoard);
        }
        return result;
    }
}
