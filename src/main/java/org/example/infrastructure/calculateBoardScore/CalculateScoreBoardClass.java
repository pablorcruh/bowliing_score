package org.example.infrastructure.calculateBoardScore;

import org.example.domain.services.ICalculateScoreService;

public class CalculateScoreBoardClass {
    private ICalculateScoreService calculateScoreService;

    public ICalculateScoreService getCalculateScoreService() {
        return calculateScoreService;
    }

    public void setCalculateScoreService(ICalculateScoreService calculateScoreService) {
        this.calculateScoreService = calculateScoreService;
    }

    public CalculateScoreBoardClass(ICalculateScoreService calculateScoreService) {
        this.calculateScoreService = calculateScoreService;
    }
}
