import java.io.*;
import javax.lang.model.util.ElementScanner6;

public class Bag
{

    public int bagsitems = 0;
    public int numberofEXPpotion = 0;
    public int numberofHPpotion = 0;
    public int coin=0;
    Item its = new Item();
    EXPPotion exppotion = new EXPPotion();
    HPPotion hppotion = new HPPotion();
    GoldCoin goldcoins = new GoldCoin();

    public int useGoldCoin(){
        return goldcoins.getProperty();
    }
    public int useEXPPotion(){
        return exppotion.getProperty();
    }
    public int useHPPotion(){
        return hppotion.getProperty();
    }
    public void decreaseGoldCoin(){
        --coin;
    }
    public void increaseGoldCoin(){
        ++coin;
    }
    public void decreaseItemEXPPotion(){
        --numberofEXPpotion;
        --bagsitems;
    }
    public void increaseEXPPotion(){
        ++numberofEXPpotion;
        ++bagsitems;
    }
    public void decreaseItemHPPotion(){
        --numberofHPpotion;
        --bagsitems;
    }
    public void increaseHPPotion(){
        ++numberofHPpotion;
        ++bagsitems;
    }
    public int returnCoins(){
        return coin;
    }
    public int returnEXPPotion(){
        return numberofEXPpotion;
    }
    public int returnHPPotion(){
        return numberofHPpotion;
    }
    public int BagsItems(){
        return bagsitems;
    }
    public void printItemsProperty(){
        exppotion.printEXPPotion();
        hppotion.printHPPotion();
    }

}