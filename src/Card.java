import java.util.ArrayList;
import java.util.function.Function;

public class Card {

    private String name;
    private ArrayList arguments;
    private Function<ArrayList, Boolean> atActivation;
    private boolean canBeKept;

    public Card(String name, ArrayList arguments, Function atActivation, boolean canBeKept) {
        this.atActivation = atActivation;
        this.arguments = arguments;
        this.name = name;
        this.canBeKept = canBeKept;
    }

    public void use(Player player){
        arguments.add(0,player);
        atActivation.apply(arguments);
    }

    public boolean isCanBeKept() {
        return canBeKept;
    }
}
