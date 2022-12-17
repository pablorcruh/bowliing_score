package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    static HashMap<String, Integer> scoreMap = new HashMap<>();
    static int turn = 0;
    static int shot = 1;
    static String actual = null;

    static int actualTurns = 0;
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
        if(actual == null){
            turn = 1;
            actual = name;
        }
        key = name + "-" + turn + "-" + shot;
        if(actual.equals(name) && points <10){
            actualTurns++;
        }else{
            actualTurns = 2;
        }
        if(actual.equals(name) && actualTurns==2){
            turn++;
        }
        if(points==10){
            shot = 1;
        }else{
            shot++;
        }
        scoreMap.put(key, points);
    }
}
