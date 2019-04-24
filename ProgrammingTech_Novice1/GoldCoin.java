import java.io.*;

public class GoldCoin extends Item{

    public GoldCoin(){
        super.setName("Gold Coin");
        super.setProperty(20);
    }

    public void printEXPPotion(){
        System.out.println(super.getName() + " CASH + " +super.getProperty());
    }
}