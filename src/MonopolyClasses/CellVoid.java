package MonopolyClasses;

import java.util.ArrayList;
import java.util.function.Function;

public class CellVoid extends Cell{

    public CellVoid(String name){
        super(name);
    }

    @Override
    public void apply(Player player) {
        System.out.println(this);
    }
}
