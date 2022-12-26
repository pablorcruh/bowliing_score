package org.example.domain.services;

import org.example.domain.ScoreBoardRow;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface ICalculateScoreService {

    List<ScoreBoardRow> calculateScoreBoardRow(List<ScoreBoardRow> scoreBoard);
}
