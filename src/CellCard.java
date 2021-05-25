import java.util.ArrayList;
import java.util.LinkedList;

public class CellCard extends Cell {

    LinkedList<Card> deck;

    public CellCard(String name, LinkedList<Card> deck){
        super(name);
        this.deck = deck;
    }

    @Override
    public void apply(Player player) {
        Card card = deck.removeLast();
        if (card.isCanBeKept()){
            player.addCard(card);
        }
        else {
            card.use(player);
        }
    }
}
