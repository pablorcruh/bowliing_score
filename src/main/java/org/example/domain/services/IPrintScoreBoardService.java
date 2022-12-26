package org.example.domain.services;

import org.example.domain.ScoreBoardRow;

import java.util.List;

public interface IPrintScoreBoardService {

    Void printScoreBoardRow(List<ScoreBoardRow> scoreBoard);

}
