import java.io.*;

public class EXPPotion extends Item{

    public EXPPotion(){
        super.setName("EXPPotion");
        super.setProperty(20);
    }

    public void printEXPPotion(){
        System.out.println(super.getName() + " (EXP + " +super.getProperty()+")");
    }
}