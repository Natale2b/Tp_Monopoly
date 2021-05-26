package MonopolyClasses;

import java.util.ArrayList;

public interface SpecialCellFunctions {

    static void allezEnPrison (ArrayList<Object> parameters){
        Player player = (Player) parameters.get(0);
        Board board = (Board) parameters.get(1);
        player.setPositionOnBoard(board.getCellPosition("prison"));
        player.setStuck(3);
    }



}
