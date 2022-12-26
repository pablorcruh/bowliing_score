package org.example.infrastructure.printBoardService;

public class PrintBoardClassFactory {

    public PrintBoardClass printBoardScore(){
        return new PrintBoardClass(new PrintScoreBoardService());
    }
}
