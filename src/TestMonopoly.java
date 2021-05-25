import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;

public class TestMonopoly {
    public static void main(String[] args){
        //Game jeu1 = new Game(10, 3, 100);

        Function<ArrayList,Boolean> f1 = CardFunctions::function1;
        Function<ArrayList,Boolean> f2 = CardFunctions::function2;
        Card card1 = new Card("card1",new ArrayList(),f1,false);
        Card card2 = new Card("card1",new ArrayList(),f2,false);
        LinkedList<Card> deck1 = new LinkedList<>();
        deck1.add(card1);
        deck1.add(card2);

        GroupProperties group1 = new GroupProperties("groupe1");
        CellProperty prop1 = new CellProperty("p1",100,50,80,group1);
        CellProperty prop2 = new CellProperty("p2",100,50,80,group1);
        CellProperty prop3 = new CellProperty("p3",100,50,80,group1);
        CellCard cellCard1 = new CellCard("chance",deck1);
        Cell[] listeDeCases1 = {prop1,prop2,cellCard1,prop3};
        Board board = new Board(listeDeCases1);
        Game g1 = new Game(board,3,20);
    }
}
