import java.io.*;
import java.util.*;


public class Item{
    private String name = new String();
    private int hp;

    public Item(){
        name = "potion";
        hp = 50;
    }

    public int getItem(){
        return this.hp;
    }
}
