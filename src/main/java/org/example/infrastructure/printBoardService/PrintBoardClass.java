package org.example.infrastructure.printBoardService;

import org.example.domain.services.IPrintScoreBoardService;

public class PrintBoardClass {

    private IPrintScoreBoardService printScoreBoardService;

    public PrintBoardClass(IPrintScoreBoardService printScoreBoardService) {
        this.printScoreBoardService = printScoreBoardService;
    }

    public IPrintScoreBoardService getPrintScoreBoardService() {
        return printScoreBoardService;
    }

    public void setPrintScoreBoardService(IPrintScoreBoardService printScoreBoardService) {
        this.printScoreBoardService = printScoreBoardService;
    }
}
