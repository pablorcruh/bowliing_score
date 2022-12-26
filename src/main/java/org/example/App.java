package org.example;

import org.example.domain.ScoreBoardRow;
import org.example.domain.services.ICalculateScoreService;
import org.example.domain.services.IFillScoreBoardService;
import org.example.domain.services.IPrintScoreBoardService;
import org.example.infrastructure.calculateBoardScore.CalculateScoreBoardClass;
import org.example.infrastructure.calculateBoardScore.CalculateScoreBoardFactory;
import org.example.infrastructure.fillBoardScore.FillBoardClass;
import org.example.infrastructure.fillBoardScore.FillBoardClassFactory;
import org.example.infrastructure.printBoardService.PrintBoardClass;
import org.example.infrastructure.printBoardService.PrintBoardClassFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App 
{
    public  static FillBoardClass fillBoardClassFactory = new FillBoardClassFactory().generateBoardScore();
    static IFillScoreBoardService fillService = fillBoardClassFactory.getFillScoreBoardService();

    public static CalculateScoreBoardClass calculateScoreBoardClassFactory = new CalculateScoreBoardFactory().getCalculateScoreBoard();
    static ICalculateScoreService calculateService = calculateScoreBoardClassFactory.getCalculateScoreService();

    public static PrintBoardClass printBoardClassFactory = new PrintBoardClassFactory().printBoardScore();
    static IPrintScoreBoardService printService = printBoardClassFactory.getPrintScoreBoardService();


    static HashMap<String, Integer> scoreMap = new HashMap<>();
    static int turn = 0;
    static int shot = 1;
    static String firstPlayer = null;

    static Set<String> playersList = new HashSet<>();
    static int attemptCount=1;
    static Boolean changeTurn = false;
    static Boolean firstTurn = true;

    public static void main( String[] args )
    {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("/Users/pablo.cruz/Documents/my_projects/bowling_score/src/main/java/org/example/score.txt"));
            String line = reader.readLine();
            while (line != null) {
                fillScoreMap(line);
                line = reader.readLine();

            }
            List<ScoreBoardRow> result =  fillService.fillScoreBoardRow(scoreMap, playersList);
            result = calculateService.calculateScoreBoardRow(result);
            printService.printScoreBoardRow(result);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillScoreMap(String line){
        int points;
        String key ="";
        String[] entry = line.split(" ");
        String name = entry[0];
        if(entry[1].equals("F")){
            points = 0;
        }else {
           points  = Integer.parseInt(entry[1]);
        }
        if(firstPlayer == null){
            turn = 1;
            firstPlayer = name;
        }
        if(firstPlayer.equals(name) && changeTurn){
            if(turn < 10){
                turn++;
            }
            shot =1;
            changeTurn = false;
            attemptCount = 0;
            firstTurn = false;

        }

        if(firstTurn){
            playersList.add(name);
        }

        key = name + "-" + turn + "-" + shot;
        scoreMap.put(key, points);

        if(firstPlayer.equals(name) && points < 10){
            attemptCount++;
        }else{
            attemptCount= 2;
        }

        if(firstPlayer.equals(name) && attemptCount==2 && turn < 10){
            changeTurn = true;
        }

        if(points==10 && turn < 10){
            shot=1;
        }else{
            shot++;
        }
        if(shot>=3 && turn<10){
            shot=1;
        }
        if(shot > 3 && turn >9){
            shot = 1;
        }
    }

}
