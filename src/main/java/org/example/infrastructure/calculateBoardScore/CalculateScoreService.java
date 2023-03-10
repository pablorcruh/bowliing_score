package org.example.infrastructure.calculateBoardScore;

import org.example.domain.ScoreBoardRow;
import org.example.domain.services.ICalculateScoreService;

import java.util.List;

public class CalculateScoreService implements ICalculateScoreService {
    @Override
    public List<ScoreBoardRow> calculateScoreBoardRow(List<ScoreBoardRow> scoreBoard) {
        for (ScoreBoardRow row:scoreBoard) {
            int previousResult =0;
            int partialResult = 0;
            for(int j = 1; j <= 10; j++){

                int value = row.getRegularSlots()[j].getFirstShot();
                int complementValue = row.getRegularSlots()[j].getSecondShot();
                if(value < 10){
                    int complement = 10 - value;
                    if(complementValue == complement){
                        int nextValue = row.getRegularSlots()[j+1].getFirstShot();
                        partialResult = previousResult + 10 + nextValue;
                    }else{
                        int nextValue1 = row.getRegularSlots()[j].getFirstShot();
                        int nextValue2 = row.getRegularSlots()[j].getSecondShot();
                        partialResult = previousResult + nextValue1 + nextValue2;
                    }
                }
                if(value == 10){
                    if(j <10){
                        int nextValue2 = 0;
                        int nextValue1 = row.getRegularSlots()[j+1].getFirstShot();
                        if(nextValue1 == 10 && j < 9){
                            nextValue2 = row.getRegularSlots()[j+2].getFirstShot();
                        }else{
                            nextValue2 = row.getRegularSlots()[j+1].getSecondShot();
                        }
                        partialResult = previousResult + 10 + nextValue1 + nextValue2;

                    }else{
                        int nextValue1 = row.getRegularSlots()[j].getFirstShot();
                        int nextValue2 = row.getRegularSlots()[j].getSecondShot();
                        int nextValue3 = row.getRegularSlots()[j].getThirdShot();
                        partialResult = previousResult + nextValue1 + nextValue2 + nextValue3;
                    }
                }
                row.getRegularSlots()[j].setResult(partialResult);
                previousResult = partialResult;
            }
        }
        return scoreBoard;
    }
}
