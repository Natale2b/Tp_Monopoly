import java.util.ArrayList;

public interface CardFunctions {

    public static Boolean function1(ArrayList parameters) {
        Player player = (Player) parameters.get(0);
        player.addMoney(200);
        return true;
    }

    public static Boolean function2(ArrayList parameters) {
        Player player = (Player) parameters.get(0);
        player.substractMoney(200);
        return true;
    }

}
