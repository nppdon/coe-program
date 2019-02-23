import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class main
{
public static void main(String args[]){
    Novice nv = new Novice();
    Scanner sc = new Scanner(System.in);
    Bag myBag = new Bag();
    Item its = new Item();
    Assassin as = new Assassin();
    Wizard wz = new Wizard();
    Random rand = new Random();

    System.out.println("HP : " + nv.GetHP());
    System.out.println("EXP : : " + nv.GetEXP());
    System.out.println("ATTACK : " + nv.GetAttack());
    System.out.println("BAG :: " +myBag.BagsItems() + "/10 :: HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
    System.out.println(" ");
    System.out.println("Enter 1 to Attact the Enemies");
    System.out.println("Enter 2 to eat something");
    System.out.println("Enter 3 to sleep");
    System.out.println("Enter 'HPPotion' or 'EXPPotion' to use potion");
    System.out.println("Enter 'bag' to open your bag");
    System.out.println(" ");

    while(nv.GetHP()>0){

        System.out.print("Enter command :");
        String command = sc.nextLine();
        System.out.println("");

        if(nv.GetEXP()<45){
            if(command.equals("1") == true){

                nv.AttackEnemies();
                System.out.println("ENERMIES DOWN ...");

                int n = rand.nextInt(2); // random to getHPPotion or EXPPotion
                if(myBag.BagsItems()<10){
                    if(n == 0){
                        myBag.increaseHPPotion();
                    }
                    else{
                        myBag.increaseEXPPotion();
                    }
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
            else if(command.equals("HPPotion") == true && myBag.returnHPPotion()!=0){
                System.out.println("USED HPPotion ...");
                System.out.println("");
                nv.usingHPPotion();
                myBag.decreaseItemHPPotion();
            }
            else if(command.equals("EXPPotion") == true && myBag.returnEXPPotion()!=0){
                System.out.println("USED EXPPotion ...");
                System.out.println("");
                nv.usingEXPPotion();
                myBag.decreaseItemEXPPotion();
            }
            else if(command.equals("HPPotion") == true && myBag.returnHPPotion()==0){
                System.out.println("NO MORE HPPOTION!!!!!");
                System.out.println("");
            }
            else if(command.equals("EXPPotion") == true && myBag.returnEXPPotion()==0){
                System.out.println("NO MORE EXPPOTION!!!!!");
                System.out.println("");
            }
            else if(command.equals("bag")== true){
                myBag.printItemsProperty();
                System.out.println("Number of HPPotion : "+myBag.returnHPPotion());
                System.out.println("Number of EXPPotion : "+myBag.returnEXPPotion());
            }
            else if(command.equals("how2p") == true){
                System.out.println(" ");
                System.out.println("Enter 1 to Attack the Enemies");
                System.out.println("Enter 2 to eat something");
                System.out.println("Enter 3 to sleep");
                System.out.println("Enter 'HPPotion' or'EXPPotion' to use potion");
                System.out.println("Enter 'bag' to open your bag");
                System.out.println(" ");
            }
        }

        else{
            System.out.println("Wait a moment ... your exp is enough to evolve yourself ");
            System.out.println("Choose your career ... Assassin or Wizard (Enter Assassin or Wizard)");
            System.out.print("I wanna be ... ");
            String carreer = sc.nextLine();
            System.out.println("");

            if(carreer.equals("Assassin") == true){
                System.out.println("You are Assassin NOW!!!!");
                System.out.println("HP+50 EXP+20 ATTACK +50");
                System.out.println("You got new Skill to attack enermies ... enter '4' to try ...");
                
                as.setAssassin(nv.GetHP(), nv.GetEXP(), nv.GetAttack());

                System.out.println(" ");
                System.out.println("HP : " + as.GetHP());
                System.out.println("EXP : : " + as.GetEXP());
                System.out.println("ATTACK : " + as.GetAttack());
                System.out.println("BAG :: " +myBag.BagsItems() + "/10 :: HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                System.out.println("Enter 'how2p' to show how to play this game");
                System.out.println(" ");

                while(as.GetHP()>0){

                    System.out.print("Enter command :");
                    String ascommand = sc.nextLine();
                    System.out.println("");

                    if(ascommand.equals("1") == true){
                        as.AttackEnemies();
                        System.out.println("ENERMIES DOWN ...");

                        int n = rand.nextInt(2); // random to getHPPotion or EXPPotion
                        if(myBag.BagsItems()<10){
                            if(n == 0){
                                myBag.increaseHPPotion();
                            }
                            else{
                                myBag.increaseEXPPotion();
                            }
                        }
                        else if(myBag.BagsItems()>=10){
                            System.out.println("DROP SOME ITEMS!!! NO MORE SPACE IN YOUR BAG");
                        }
                    }
                    if(ascommand.equals("4") == true){
                        as.AssassinAttack();
                        System.out.println("ENERMIES DOWN ...");

                        int n = rand.nextInt(2); // random to getHPPotion or EXPPotion
                        if(myBag.BagsItems()<10){
                            if(n == 0){
                                myBag.increaseHPPotion();
                            }
                            else{
                                myBag.increaseEXPPotion();
                            }
                        }
                        else if(myBag.BagsItems()>=10){
                            System.out.println("DROP SOME ITEMS!!! NO MORE SPACE IN YOUR BAG");
                        }
                    }
                    else if(ascommand.equals("2") == true){
                        System.out.println("HP +100");
                        as.Eatting();
                    }
                    else if(ascommand.equals("3") == true){
                        System.out.println("HP +200 EXP -10");
                        as.Sleeping();
                    }
                    else if(ascommand.equals("HPPotion") == true && myBag.returnHPPotion()!=0){
                        System.out.println("USED HPPotion ...");
                        System.out.println("");
                        as.usingHPPotion();
                        myBag.decreaseItemHPPotion();
                    }
                    else if(ascommand.equals("EXPPotion") == true && myBag.returnEXPPotion()!=0){
                        System.out.println("USED EXPPotion ...");
                        System.out.println("");
                        as.usingEXPPotion();
                        myBag.decreaseItemEXPPotion();
                    }
                    else if(ascommand.equals("HPPotion") == true && myBag.returnHPPotion()==0){
                        System.out.println("NO MORE HPPOTION!!!!!");
                        System.out.println("");
                    }
                    else if(ascommand.equals("EXPPotion") == true && myBag.returnEXPPotion()==0){
                        System.out.println("NO MORE EXPPOTION!!!!!");
                        System.out.println("");
                    }
                    else if(ascommand.equals("bag")== true){
                        myBag.printItemsProperty();
                        System.out.println("Number of HPPotion : "+myBag.returnHPPotion());
                        System.out.println("Number of EXPPotion : "+myBag.returnEXPPotion());
                    }
                    else if(ascommand.equals("how2p") == true){
                        System.out.println(" ");
                        System.out.println("Enter 1 to Attack the Enemies");
                        System.out.println("Enter 2 to eat something");
                        System.out.println("Enter 3 to sleep");
                        System.out.println("Enter 4 to use Assassin's Skill to Attack the Enemies");
                        System.out.println("Enter 'HPPotion' or 'EXPPotion' to use potion");
                        System.out.println("Enter 'bag' to open your bag");
                        System.out.println(" ");
                    }

                    System.out.println(" ");
                    System.out.println("HP : " + as.GetHP());
                    System.out.println("EXP : : " + as.GetEXP());
                    System.out.println("ATTACK : " + as.GetAttack());
                    System.out.println("BAG :: " +myBag.BagsItems() + "/10 :: HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                    System.out.println("Enter 'how2p' to show how to play this game");
                    System.out.println(" ");
                }
                break;
            }
            else if(carreer.equals("Wizard")==true){
                wz.setWizard(nv.GetHP(), nv.GetEXP(), nv.GetAttack());
                System.out.println("You are WIZARD NOW!!!!!");
                System.out.println("HP+50 EXP+5 ATTACK+10");
                System.out.println("You got new Skill to attack enermies ... enter '4' to try ...");
                
                System.out.println(" ");
                System.out.println("HP : " + wz.GetHP());
                System.out.println("EXP : : " + wz.GetEXP());
                System.out.println("ATTACK : " + wz.GetAttack());
                System.out.println("BAG :: " +myBag.BagsItems() + "/10 :: HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                System.out.println("Enter 'how2p' to show how to play this game");
                System.out.println(" ");

                while(wz.GetHP()>0){

                    System.out.print("Enter command :");
                    String wzcommand = sc.nextLine();
                    System.out.println("");

                    if(wzcommand.equals("1") == true){
                        wz.AttackEnemies();
                        System.out.println("ENERMIES DOWN ...");

                        int n = rand.nextInt(2); // random to getHPPotion or EXPPotion
                        if(myBag.BagsItems()<10){
                            if(n == 0){
                                myBag.increaseHPPotion();
                            }
                            else{
                                myBag.increaseEXPPotion();
                            }
                        }
                        else if(myBag.BagsItems()>=10){
                            System.out.println("DROP SOME ITEMS!!! NO MORE SPACE IN YOUR BAG");
                        }
                    }
                    if(wzcommand.equals("4") == true){
                        wz.WizardAttack();
                        System.out.println("ENERMIES DOWN ...");

                        int n = rand.nextInt(2); // random to getHPPotion or EXPPotion
                        if(myBag.BagsItems()<10){
                            if(n == 0){
                                myBag.increaseHPPotion();
                            }
                            else{
                                myBag.increaseEXPPotion();
                            }
                        }
                        else if(myBag.BagsItems()>=10){
                            System.out.println("DROP SOME ITEMS!!! NO MORE SPACE IN YOUR BAG");
                        }
                    }
                    else if(wzcommand.equals("2") == true){
                        System.out.println("HP +100");
                        wz.Eatting();
                    }
                    else if(wzcommand.equals("3") == true){
                        System.out.println("HP +200 EXP -10");
                        wz.Sleeping();
                    }
                    else if(wzcommand.equals("HPPotion") == true && myBag.returnHPPotion()!=0){
                        System.out.println("USED HPPotion ...");
                        System.out.println("");
                        wz.usingHPPotion();
                        myBag.decreaseItemHPPotion();
                    }
                    else if(wzcommand.equals("EXPPotion") == true && myBag.returnEXPPotion()!=0){
                        System.out.println("USED EXPPotion ...");
                        System.out.println("");
                        wz.usingEXPPotion();
                        myBag.decreaseItemEXPPotion();
                    }
                    else if(wzcommand.equals("HPPotion") == true && myBag.returnHPPotion()==0){
                        System.out.println("NO MORE HPPOTION!!!!!");
                        System.out.println("");
                    }
                    else if(wzcommand.equals("EXPPotion") == true && myBag.returnEXPPotion()==0){
                        System.out.println("NO MORE EXPPOTION!!!!!");
                        System.out.println("");
                    }
                    else if(wzcommand.equals("bag")== true){
                        myBag.printItemsProperty();
                        System.out.println("Number of HPPotion : "+myBag.returnHPPotion());
                        System.out.println("Number of EXPPotion : "+myBag.returnEXPPotion());
                    }
                    else if(wzcommand.equals("how2p") == true){
                        System.out.println(" ");
                        System.out.println("Enter 1 to Attack the Enemies");
                        System.out.println("Enter 2 to eat something");
                        System.out.println("Enter 3 to sleep");
                        System.out.println("Enter 4 to use Wizard's Skill to Attack the Enemies");
                        System.out.println("Enter 'HPPotion' or 'EXPPotion' to use potion");
                        System.out.println("Enter 'bag' to open your bag");
                        System.out.println(" ");
                    }

                    System.out.println(" ");
                    System.out.println("HP : " + wz.GetHP());
                    System.out.println("EXP : : " + wz.GetEXP());
                    System.out.println("ATTACK : " + wz.GetAttack());
                    System.out.println("BAG :: " +myBag.BagsItems() + "/10 :: HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                    System.out.println("Enter 'how2p' to show how to play this game");
                    System.out.println(" ");
                }
                break;
            }

        }

        System.out.println(" ");
        System.out.println("HP : " + nv.GetHP());
        System.out.println("EXP : : " + nv.GetEXP());
        System.out.println("ATTACK : " + nv.GetAttack());
        System.out.println("BAG :: " +myBag.BagsItems() + "/10 :: HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
        System.out.println("Enter 'how2p' to show how to play this game");
        System.out.println(" ");
        
    }
}
}