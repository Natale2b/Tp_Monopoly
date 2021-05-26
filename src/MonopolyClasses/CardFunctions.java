package MonopolyClasses;

import java.util.ArrayList;

public interface CardFunctions {

    static void function1(ArrayList<?> parameters) {
        Player player = (Player) parameters.get(0);
        player.addMoney(200);
    }

    static void function2(ArrayList<?> parameters) {
        Player player = (Player) parameters.get(0);
        player.subtractMoney(200);
    }

}
