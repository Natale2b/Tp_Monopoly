import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

public class CellSpecial extends Cell {



    Function<ArrayList, Boolean> effet;
    ArrayList arguments;

    public CellSpecial(String name, ArrayList arguments, Function effet){
        super(name);
        this.effet = effet;
        this.arguments = arguments;

    }

    @Override
    public void apply(Player player) {
        arguments.add(0,player);
        effet.apply(arguments);
    }

    private String toPrint(){
        return "todo";
    }
}
