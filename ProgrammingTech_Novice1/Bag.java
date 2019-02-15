import java.io.*;
import javax.lang.model.util.ElementScanner6;

public class Bag
{

    public int bagsitems = 0;
    public int numberofpotion = 0;
    Item its = new Item();

    public int usePotion(){
        return its.getItem();
    }
    public void decreaseItemPotion(){
        --numberofpotion;
        --bagsitems;
    }
    public void increasePotion(){
        ++numberofpotion;
        ++bagsitems;
    }
    public int returnPotion(){
        return numberofpotion;
    }

    public int BagsItems(){
        return bagsitems;
    }

}