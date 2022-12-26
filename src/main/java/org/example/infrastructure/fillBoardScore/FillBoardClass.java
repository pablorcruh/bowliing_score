package org.example.infrastructure.fillBoardScore;

import org.example.domain.services.IFillScoreBoardService;

public class FillBoardClass {
    private IFillScoreBoardService fillScoreBoardService;

    public FillBoardClass(IFillScoreBoardService fillScoreBoardService) {
        this.fillScoreBoardService = fillScoreBoardService;
    }

    public IFillScoreBoardService getFillScoreBoardService() {
        return fillScoreBoardService;
    }

    public void setFillScoreBoardService(IFillScoreBoardService fillScoreBoardService) {
        this.fillScoreBoardService = fillScoreBoardService;
    }
}
