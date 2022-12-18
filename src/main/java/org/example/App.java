package org.example;

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
                // read next line
                line = reader.readLine();
            }

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
            turn++;
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

        if(firstPlayer.equals(name) && attemptCount==2){
            changeTurn = true;
        }
        if(points==10){
            shot=1;
        }else{
            shot++;
        }
        if(shot>=3 && turn<9){
            shot=1;
        }


    }
}
