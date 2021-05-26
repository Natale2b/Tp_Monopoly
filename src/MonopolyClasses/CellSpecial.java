package MonopolyClasses;

import java.util.ArrayList;
import java.util.function.Consumer;
public class CellSpecial extends Cell {


    ArrayList<Object> variables;
    Consumer<ArrayList<Object>> effet;
    ArrayList<Object> arguments;

    public CellSpecial(String name, ArrayList<Object> arguments, Consumer<ArrayList<Object>> effet){
        super(name);
        this.effet = effet;
        this.arguments = arguments;
    }

    public CellSpecial(String name, ArrayList<Object> arguments, Consumer<ArrayList<Object>> effet, ArrayList<Object> variables){
        super(name);
        this.effet = effet;
        this.arguments = arguments;
        this.variables = variables;
    }


    @Override
    public void apply(Player player) {
        arguments.add(0, player);
        arguments.add(1, board);
        effet.accept(arguments);
    }

}
