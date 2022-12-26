package org.example.infrastructure.printBoardService;

import org.example.domain.ScoreBoardRow;
import org.example.domain.services.IPrintScoreBoardService;

import java.util.List;
import java.util.Objects;

public class PrintScoreBoardService implements IPrintScoreBoardService {
    @Override
    public Void printScoreBoardRow(List<ScoreBoardRow> scoreBoard) {
        System.out.print("Frame         ");
        for(int i = 1; i <= 10; i++){
            System.out.print(i+ "      ");
        }
        System.out.println();
        for (ScoreBoardRow row : scoreBoard){
            System.out.println(row.getPlayerName());
            System.out.print("Pinfalls    ");
            for (int i=1; i <= 10; i ++){
                int value = row.getRegularSlots()[i].getFirstShot();
                int complement =0;
                int complementValue = 0;
                if(value != 10){
                    complementValue = row.getRegularSlots()[i].getSecondShot();
                    complement = 10 - value;
                    if(complement == complementValue){
                        System.out.print("  "+value + "  /  ");
                    }else{
                        System.out.print("  "+value + "  " + complementValue + "  ");
                    }
                }else if (value ==10 && i <10){
                    System.out.print("  X  ");
                }
                if(i == 10){
                    int value1 = row.getRegularSlots()[i].getFirstShot();
                    int value2 = row.getRegularSlots()[i].getSecondShot();
                    int value3 = row.getRegularSlots()[i].getThirdShot();
                    System.out.print(value1==10? "  X  ": value1+ "  ");
                    System.out.print(value2==10? "  X  ": value2+ "  ");
                    System.out.println(value3==10? "  X  ": value3+ "  ");
                }
            }
            System.out.print("Score       ");
            for (int i = 1;i <= 10; i ++){
                int result = row.getRegularSlots()[i].getResult();
                System.out.print("  "+ result + "   ");
            }
            System.out.println();

        }
        return null;
    }
}
