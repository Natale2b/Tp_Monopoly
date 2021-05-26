package tests;


import junit.framework.TestCase;
import org.junit.*;

import MonopolyClasses.Board;
import MonopolyClasses.Cell;
import MonopolyClasses.CellProperty;
import MonopolyClasses.GroupProperties;
import MonopolyClasses.Player;

public class PlayerTests extends TestCase {

    Player player = new Player("joueur1");
    Player player2 = new Player("joueur1");


    @Before
    public void setUp(){
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(1500,player2.getMoney());
        player2.subtractMoney(200);
        Assert.assertEquals(1300,player2.getMoney());

    }
}