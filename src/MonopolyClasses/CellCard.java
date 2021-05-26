package MonopolyClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class CellCard extends Cell {

    public LinkedList<Card> deck;
    public LinkedList<Card> actualDeck;

    public CellCard(String name, LinkedList<Card> deck){
        super(name);
        this.deck = deck;
        this.actualDeck = (LinkedList<Card>) deck.clone();
        Collections.shuffle(this.actualDeck);
    }

    @Override
    public void apply(Player player) {
        Card card = actualDeck.removeLast();
        if (card.isCanBeKept()){
            player.addCard(card);
        }
        else {
            card.use(player);
        }
        if (actualDeck.size() == 0){
            actualDeck = (LinkedList<Card>) deck.clone();
            Collections.shuffle(this.actualDeck);
        }
    }
}
