package org.example.infrastructure.fillBoardScore;

public class FillBoardClassFactory {

    public FillBoardClass generateBoardScore(){
        return new FillBoardClass(new FillScoreBoardService());
    }
}
