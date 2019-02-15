import java.io.*;
import java.util.Scanner;

public class main
{
public static void main(String args[])
{
    Novice nv = new Novice();
    Scanner sc = new Scanner(System.in);
    Bag myBag = new Bag();
    Item its = new Item();

    System.out.println("HP : " + nv.GetHP());
    System.out.println("EXP : : " + nv.GetEXP());
    System.out.println("ATTACK : " + nv.GetAttack());
    System.out.println("BAG :: " +myBag.BagsItems() + "/10 :: Potion = " +myBag.returnPotion() );
    System.out.println(" ");
    System.out.println("Enter 1 to Attact the Enemies");
    System.out.println("Enter 2 to eat something");
    System.out.println("Enter 3 to sleep");
    System.out.println("Enter 'potion' to use potion");
    System.out.println(" ");

    while(nv.GetHP()>0){

    System.out.print("Eneter command :");
    String command = sc.nextLine();


    if(command.equals("1") == true){
        nv.AttackEnemies();
        System.out.println("ENERMIES DOWN ...");
        if(myBag.BagsItems()<10){
            myBag.increasePotion();
        }
        else if(myBag.BagsItems()>=10){
            System.out.println("DROP SOME ITEMS!!! NO MORE SPACE IN YOUR BAG");
        }
    }
    else if(command.equals("2") == true){
        System.out.println("HP +100");
        nv.Eatting();
    }
    else if(command.equals("3") == true){
        System.out.println("HP +200 EXP -10");
        nv.Sleeping();
    }
    else if(command.equals("potion") == true && myBag.returnPotion()!=0){
        System.out.println("USED POTION ...");
        System.out.println("");
        nv.usingPotion();
        myBag.decreaseItemPotion();
    }
    else if(command.equals("potion") == true && myBag.returnPotion()==0){
        System.out.println("NO MORE POTION!!!!!");
        System.out.println("");
    }
    else if(command.equals("how2p") == true){
        System.out.println(" ");
        System.out.println("Enter 1 to Attack the Enemies");
        System.out.println("Enter 2 to eat something");
        System.out.println("Enter 3 to sleep");
        System.out.println("Enter 'potion' to use potion");
        System.out.println(" ");
    }

    System.out.println(" ");
    System.out.println("HP : " + nv.GetHP());
    System.out.println("EXP : : " + nv.GetEXP());
    System.out.println("ATTACK : " + nv.GetAttack());
    System.out.println("BAG :: " +myBag.BagsItems() + "/10 :: Potion = " +myBag.returnPotion() );
    System.out.println("Enter 'how2p' to show how to play this game");
    System.out.println(" ");
    }
}
}