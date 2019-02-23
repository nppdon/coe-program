import java.io.*;

public class HPPotion extends Item{

    public HPPotion(){
        super.setName("HPPotion");
        super.setProperty(50);
    }

    public void printHPPotion(){
        System.out.println(super.getName() + " (HP + " +super.getProperty()+")");
    }
}