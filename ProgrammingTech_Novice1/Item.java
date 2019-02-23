import java.io.*;
import java.util.*;


public class Item{
    private String name = new String();
    private int property;

    public void setName(String newname){
        name=newname;
    }
    public void setProperty(int newproperty)
    {
        property=newproperty;
    }
    public String getName(){
        return name;
    }
    public int getProperty(){
        return property;
    }
}
/*    public Item(){
        name = "potion";
        hp = 50;
    }

    public int getItem(){
        return this.hp;
    }
    public String getItemsname(){
        return name;
    }
}
*/
