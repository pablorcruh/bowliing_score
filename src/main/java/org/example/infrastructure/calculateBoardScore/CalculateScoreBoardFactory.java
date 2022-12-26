package org.example.infrastructure.calculateBoardScore;

public class CalculateScoreBoardFactory {

    public CalculateScoreBoardClass getCalculateScoreBoard(){
        return new CalculateScoreBoardClass(new CalculateScoreService());
    };
}
