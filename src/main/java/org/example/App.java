package org.example;

import org.example.domain.LastSlot;
import org.example.domain.RegularSlot;
import org.example.domain.ScoreBoardRow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
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
                //System.out.println(line);
                fillScoreMap(line);
                line = reader.readLine();

            }
            List<ScoreBoardRow> result = fillScoreBoardRow(scoreMap, playersList);

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

    public static List<ScoreBoardRow> fillScoreBoardRow(HashMap<String,Integer> scoreHashMap, Set<String> players){
        List<ScoreBoardRow> result = new ArrayList<>();
        for (String player : players) {
            ScoreBoardRow userScoreBoard = new ScoreBoardRow();
            userScoreBoard.setPlayerName(player);
            for(int i = 1; i <= 10; i++){
                LastSlot lastSlot = new LastSlot();
                if(i < 10){
                    RegularSlot regularSlot = new RegularSlot();
                    Integer firstShot = scoreHashMap.get(player+"-"+i+"-"+1);
                    Integer secondShot = scoreHashMap.get(player+"-"+i+"-"+2);
                    regularSlot.setFirstShot(firstShot != null ? firstShot :0);
                    regularSlot.setSecondShot(secondShot != null ? secondShot: 0);
                    regularSlot.setPositionSlot(i);
                    userScoreBoard.addRegularSlot(regularSlot);
                }else{
                    Integer firstShot = scoreHashMap.get(player+"-"+i+"-"+1);
                    Integer secondShot = scoreHashMap.get(player+"-"+i+"-"+2);
                    Integer thirdShot = scoreHashMap.get(player+"-"+i+"-"+3);
                    lastSlot.setFirstShot(firstShot != null ? firstShot :0);
                    lastSlot.setSecondShot(secondShot != null ? secondShot: 0);
                    lastSlot.setThirdShot(thirdShot != null ? thirdShot: 0);
                    userScoreBoard.setLastSlot(lastSlot);
                }
            }
            result.add(userScoreBoard);
        }
        return result;
    }


}
