package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.domain.ScoreBoardRow;
import org.example.domain.services.ICalculateScoreService;
import org.example.domain.services.IFillScoreBoardService;
import org.example.infrastructure.calculateBoardScore.CalculateScoreBoardClass;
import org.example.infrastructure.calculateBoardScore.CalculateScoreBoardFactory;
import org.example.infrastructure.fillBoardScore.FillBoardClass;
import org.example.infrastructure.fillBoardScore.FillBoardClassFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.*;


/**
 * Unit test for simple App.
 */

public class AppTest
    extends TestCase
{

    public FillBoardClass fillBoardClassFactory = new FillBoardClassFactory().generateBoardScore();
    IFillScoreBoardService fillService = fillBoardClassFactory.getFillScoreBoardService();

    public CalculateScoreBoardClass calculateScoreBoardClassFactory = new CalculateScoreBoardFactory().getCalculateScoreBoard();
    ICalculateScoreService calculateService = calculateScoreBoardClassFactory.getCalculateScoreService();

    private HashMap<String, Integer> scoreMap = new HashMap<>();

    private Set<String> playerList =new HashSet<>();

    List<ScoreBoardRow> result = new ArrayList<>();

    @BeforeEach
    public void setup() {
        scoreMap.put("jeff-1-1",10);
        scoreMap.put("jeff-2-1",7);
        scoreMap.put("jeff-2-2",3);
        scoreMap.put("jeff-3-1",9);
        scoreMap.put("jeff-3-2",0);
        scoreMap.put("jeff-4-1",10);
        scoreMap.put("jeff-5-1",0);
        scoreMap.put("jeff-5-2",8);
        scoreMap.put("jeff-6-1",8);
        scoreMap.put("jeff-6-2",2);
        scoreMap.put("jeff-7-1",0);
        scoreMap.put("jeff-7-2",6);
        scoreMap.put("jeff-8-1",10);
        scoreMap.put("jeff-9-1",10);
        scoreMap.put("jeff-10-1",10);
        scoreMap.put("jeff-10-2",8);
        scoreMap.put("jeff-10-3",1);
        playerList.add("jeff");

        result = fillService.fillScoreBoardRow(scoreMap, playerList);

    }
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    @org.junit.jupiter.api.Test
    public void testFillScoreBoard(){
        List<ScoreBoardRow> resultTest = fillService.fillScoreBoardRow(scoreMap, playerList);
        int assert1 = resultTest.get(0).getRegularSlots()[3].getFirstShot();
        int assert2 = resultTest.get(0).getRegularSlots()[7].getSecondShot();
        int assert3 = resultTest.get(0).getRegularSlots()[10].getThirdShot();
        assertEquals(9, assert1);
        assertEquals(6, assert2);
        assertEquals(1, assert3);
    }

    @org.junit.jupiter.api.Test
    public void testCalculateScoreBoard(){
        List<ScoreBoardRow> resultTest= calculateService.calculateScoreBoardRow(result);
        int assert1 = resultTest.get(0).getRegularSlots()[3].getResult();
        int assert2 = resultTest.get(0).getRegularSlots()[7].getResult();
        int assert3 = resultTest.get(0).getRegularSlots()[10].getResult();
        assertEquals(48, assert1);
        assertEquals(90, assert2);
        assertEquals(167, assert3);
    }


}
