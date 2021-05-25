package tests;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src;
import java.util.ArrayList;

public class PlayerTests extends TestCase {

    Player player = new Player("joueur1");
    Player player2 = new Player("joueur1");

    GroupProperties group = new GroupProperties("name");

    Cell[] listeDeCases1 = {new CellProperty("aia", 100,20, new int[]{100,200,300,400,500,600}, group),
            new CellProperty("ae", 100,20, new int[]{100,200,300,400,500,600}, group),
            new CellProperty("eeeee", 100,20, new int[]{100,200,300,400,500,600}, group)};


    Board board = new Board(listeDeCases1);

    @BeforeEach
    public void setUp(){
        player.setBoard(board);
        player2.setBoard(board);
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertEquals(1200,player2.getMoney());
        Assert.assertEquals(player.getBoard(),player2.getBoard());

    }
}