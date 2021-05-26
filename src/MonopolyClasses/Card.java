package MonopolyClasses;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Card {

    private String name;
    private ArrayList<Object> arguments;
    private Consumer<ArrayList<Object>> atActivation;
    private boolean canBeKept;

    public Card(String name, ArrayList<Object> arguments,
                Consumer<ArrayList<Object>> atActivation, boolean canBeKept) {
        this.atActivation = atActivation;
        this.arguments = arguments;
        this.name = name;
        this.canBeKept = canBeKept;
    }

    public void use(Player player){
        arguments.add(0,player);
        atActivation.accept(arguments);
        System.out.println("Card : " + name + "is used !");
    }

    public boolean isCanBeKept() {
        return canBeKept;
    }
}
