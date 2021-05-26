package MonopolyClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Consumer;

public class DemoMonopoly {
    public static void main(String[] args){
        //Game jeu1 = new Game(10, 3, 100);

        Consumer<ArrayList<Object>> f1 = CardFunctions::function1;
        Consumer<ArrayList<Object>> f2 = CardFunctions::function2;
        Card card1 = new Card("card1",new ArrayList<>(),f1,false);
        Card card2 = new Card("card1",new ArrayList<>(),f2,false);
        LinkedList<Card> deck1 = new LinkedList<>();
        deck1.add(card1);
        deck1.add(card2);
        deck1.add(card2);
        deck1.add(card2);
        deck1.add(card2);

        Consumer<ArrayList<Object>> f4 = SpecialCellFunctions::allezEnPrison;




        CellVoid caseDepart = new CellVoid("Case départ");
        CellVoid repos = new CellVoid("parc gratuit");
        CellVoid prison = new CellVoid("prison");

        GroupProperties group1 = new GroupProperties("groupe1");
        CellProperty prop1 = new CellProperty("p1",100,50,500,group1);
        CellProperty prop2 = new CellProperty("p2",100,50,500,group1);
        CellProperty prop3 = new CellProperty("p3",100,50,500,group1);
        CellCard cellCard1 = new CellCard("chance",deck1);
        CellSpecial allezEnPrison = new CellSpecial("Allez En Prison",new ArrayList<>(),f4);
        Cell[] listeDeCases1 = {caseDepart,prop1,prison,prop2,prop3,allezEnPrison,repos};
        Board board = new Board(listeDeCases1);



        Game g1 = new Game(board,3,30);
    }
}
