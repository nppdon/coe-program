// NoviceGUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class NoviceGUI extends JFrame
{
    Novice nv = new Novice();
    Bag myBag = new Bag();
    Item its = new Item();
    MonsterCenter monCenter = new MonsterCenter();
    Random rand = new Random();

    public NoviceGUI()
    {

        super("NoviceGUI 1");
        this.setIconImage(new javax.swing.ImageIcon("logo.png").getImage());

        Container c = getContentPane();
        c.setLayout( new BorderLayout(10,10));


        
        JPanel leftsize = new JPanel();
        leftsize.setBorder(BorderFactory.createEmptyBorder(20, 15, 15, 0));
        leftsize.setLayout(new BoxLayout(leftsize, BoxLayout.Y_AXIS));
        JLabel nvpic = new JLabel(new ImageIcon("novicepic.gif"));
        JLabel carreer = new JLabel("      "+ nv.GetCareer());
        leftsize.add(nvpic);
        leftsize.add(carreer);

        // status part
        JPanel header = new JPanel();
        header.setBorder(BorderFactory.createEmptyBorder(15,160, 0, 0)); //บน ซ้าย ล่าง ขวา
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        /*JPanel statusline = new JPanel();
        statusline.setLayout(new GridLayout(2,1,10,5));
        JLabel hpstatus = new JLabel("HP : "+nv.GetHP());
        JLabel expstatus = new JLabel("EXP : "+nv.GetEXP());
        JLabel attackstatus = new JLabel("Attack : "+nv.GetAttack());
        JLabel killstatus = new JLabel("Killed : "+nv.GetKill());*/

        //BAG PART
        JLabel bagsstatus = new JLabel("BAG : "+ myBag.BagsItems()+ " /10 : ");
        
        JPanel HPPotions = new JPanel();
        HPPotions.setLayout(new BoxLayout(HPPotions, BoxLayout.X_AXIS));
        JLabel hppotionpic = new JLabel(new ImageIcon("HPPotion.gif"));
        JLabel hppotiontext = new JLabel(" x " + myBag.returnHPPotion());

        JPanel EXPPotions = new JPanel();
        EXPPotions.setLayout(new BoxLayout(EXPPotions, BoxLayout.X_AXIS));
        JLabel exppotionpic = new JLabel(new ImageIcon("EXPPotion.gif"));
        JLabel exppotiontext = new JLabel(" x " + myBag.returnEXPPotion());

        JLabel goldtext = new JLabel("---- trasher ---- ");


        JPanel goldcoins = new JPanel();
        goldcoins.setLayout(new BoxLayout(goldcoins, BoxLayout.X_AXIS));
        JLabel goldcoinpic = new JLabel(new ImageIcon("goldcoin.gif"));
        JLabel goldcointext = new JLabel(" x " + myBag.returnCoins());

        HPPotions.add(hppotionpic);
        HPPotions.add(hppotiontext);

        EXPPotions.add(exppotionpic);
        EXPPotions.add(exppotiontext);

        goldcoins.add(goldcoinpic);
        goldcoins.add(goldcointext);

        leftsize.add(bagsstatus); // added to under avatar
        leftsize.add(HPPotions);
        leftsize.add(EXPPotions);
        leftsize.add(goldtext);
        leftsize.add(goldcoins);

        
        //status part
        String status = new String("STATUS : HP "+nv.GetHP()+" EXP : "+nv.GetEXP()+" CASH : "+nv.GetAttack()+" KILLED : "+nv.GetKill()+" Level : "+nv.GetLevel());
        //String bagstatus = new String("BAG :: " +myBag.BagsItems() + "/10 : HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
        JLabel statusLine = new JLabel(status,SwingConstants.CENTER);
        //JLabel statusBag = new JLabel(bagstatus,SwingConstants.CENTER);
        header.add(statusLine);
        //header.add(statusBag);
        
        //State Part
        JPanel states = new JPanel();
        states.setLayout(new BoxLayout(states, BoxLayout.Y_AXIS));

        JLabel Monster1 = new JLabel(" ");
        JLabel Monster2 = new JLabel(" ");
        JLabel Monster3 = new JLabel(" ");
        JLabel selectedMonster = new JLabel(" ");
        JLabel damage = new JLabel(" ");


        // monster's pic part
        JPanel pic = new JPanel();
        //pic.setLayout(new GridLayout(1,3,5,5));
        pic.setLayout(new BoxLayout(pic,BoxLayout.X_AXIS));
        JLabel monster1pic = new JLabel(new ImageIcon(""));
        JLabel monster2pic = new JLabel(new ImageIcon(""));
        JLabel monster3pic = new JLabel(new ImageIcon(""));
        pic.add(monster1pic);
        pic.add(Box.createRigidArea(new Dimension(50,0)));
        pic.add(monster2pic);
        pic.add(Box.createRigidArea(new Dimension(50,0)));
        pic.add(monster3pic);
    
        states.add(pic);
        states.add(Monster1);
        states.add(Monster2);
        states.add(Monster3);
        states.add(selectedMonster);
        states.add(damage);
        
        
        // button part
        JPanel button = new JPanel();
        button.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));
        button.setLayout(new BoxLayout(button, BoxLayout.Y_AXIS));

        JButton jb1 = new JButton("KILL MONSTER");
        button.add(jb1);

        JButton jb2 = new JButton("EAT");
        jb2.setPreferredSize(jb1.getPreferredSize());
        button.add(jb2);

        JButton jb3 = new JButton("SLEEP");
        jb3.setPreferredSize(jb2.getPreferredSize());
        button.add(jb3);
        
        JLabel potion = new JLabel("----- Potion -----",SwingConstants.LEFT);
        button.add(potion);

        JButton jb4 = new JButton("HPPotion");
        jb4.setPreferredSize(jb1.getPreferredSize());
        button.add(jb4);
        
        JButton jb5 = new JButton("EXPPotion");
        jb5.setPreferredSize(jb1.getPreferredSize());
        button.add(jb5);

        JLabel extraskill = new JLabel("---- Extra ----",SwingConstants.LEFT);
        button.add(extraskill);

        JButton jb6 = new JButton("SHOP");
        jb5.setPreferredSize(jb1.getPreferredSize());
        button.add(jb6);

        JButton jb7 = new JButton("TRANSFER GOLD");
        jb5.setPreferredSize(jb1.getPreferredSize());
        button.add(jb7);


        //check number of potion
            jb4.setEnabled(false);
            jb5.setEnabled(false);
            jb6.setEnabled(false);
            jb7.setEnabled(false);

        jb1.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                //JPanel states = new JPanel();
                //states.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));


                monCenter.add(new Monster());
                monCenter.add(new Monster());
                monCenter.add(new Monster());
                selectedMonster.setText(" ");
                damage.setText(" ");

                Monster1.setText("MONSTER1 "+monCenter.PrintInfo(0));
                Monster2.setText("MONSTER2 "+monCenter.PrintInfo(1));
                Monster3.setText("MONSTER3 "+monCenter.PrintInfo(2));

                String mrandom1=new String("monster"+(rand.nextInt(3)+1)+".gif");
                String mrandom2=new String("monster"+(rand.nextInt(3)+1)+".gif");
                String mrandom3=new String("monster"+(rand.nextInt(3)+1)+".gif");
                monster1pic.setIcon(new ImageIcon(mrandom1));
                monster2pic.setIcon(new ImageIcon(mrandom2));
                monster3pic.setIcon(new ImageIcon(mrandom3));
                
                ImageIcon iconf = new ImageIcon("fighting.gif");
                String command = JOptionPane.showInputDialog(jb7,"Which's monster you want to kill? ENTER NUM ONLY!",null);
                //if check command

                if(command.equals("1")||command.equals("2")||command.equals("3")){
                    int result = Integer.parseInt(command);
                    nv.AttackEnemies(monCenter.getMonsterDP(result-1));
                    selectedMonster.setText("YOU CHOOSE "+monCenter.PrintInfo(result-1));
                    damage.setText("Damage to you HP - "+monCenter.getMonsterDP(result-1));
                    Monster1.setText(" ");
                    Monster2.setText(" ");
                    Monster3.setText(" ");
                    monster1pic.setIcon(new ImageIcon(" "));
                    monster2pic.setIcon(new ImageIcon(" "));
                    monster3pic.setIcon(new ImageIcon(" "));

                    //check that can get coins or not?
                    if(monCenter.getMonsterHP(result-1)>=60){
                        if(rand.nextInt(2)==1){
                            myBag.increaseGoldCoin();
                            System.out.println("1");
                        }
                        
                    }


                    int n = rand.nextInt(2);
                    if(myBag.BagsItems()<10){
                        if(n == 0){
                            myBag.increaseHPPotion();
                        }
                        else{
                            myBag.increaseEXPPotion();
                        }
                    }
                    else if(myBag.BagsItems()>=10){
                        JOptionPane.showMessageDialog(null, 
                                "DROP SOME ITEMS!!! NO MORE SPACE IN YOUR BAG", 
                                "BAG FULL!", 
                                JOptionPane.WARNING_MESSAGE);
                    }

                }
                else{
                    selectedMonster.setText("YOU CHOOSE UNEXIST MONSTER!");
                    damage.setText("Damage to you HP -0 ");
                }

                if(myBag.returnHPPotion()==0)
                    jb4.setEnabled(false);
                else
                    jb4.setEnabled(true);

                if(myBag.returnEXPPotion()==0)
                    jb5.setEnabled(false);
                else
                    jb5.setEnabled(true);


                //level up
                if((nv.GetKill()%10)==0)
                    nv.setLevel();

                // check hp
                if(nv.GetHP()<=0){
                    JOptionPane.showMessageDialog(c,"You've died ... REST IN PEACE","RIP",JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                }

                statusLine.setText("STATUS : HP "+nv.GetHP()+" EXP : "+nv.GetEXP()+" CASH : "+nv.GetAttack()+" KILLED : "+nv.GetKill()+" Level : "+nv.GetLevel());
                //statusBag.setText("BAG :: " +myBag.BagsItems() + "/10 : HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                bagsstatus.setText("BAG : "+ myBag.BagsItems()+ " /10 : ");
                goldcointext.setText(" x "+myBag.returnCoins());
                hppotiontext.setText(" x "+myBag.returnHPPotion());
                exppotiontext.setText(" x "+myBag.returnEXPPotion());

                monCenter.removeMonster();

                if(nv.GetEXP()>=45 && nv.GetCareer().equals("Novice")){

                    Object[] options = {"Wizard","Assassin","Skip"};

                    final ImageIcon icon = new ImageIcon(getClass().getResource("career.png"));
                    
                    int n = JOptionPane.showOptionDialog(null,"What's carreer you wanna be?",
                    "Choose new career",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[2]);
                    System.out.println(n);

                    if(n==0){
                        nv.setName("Wizard");
                        carreer.setText("        "+ nv.GetCareer());
                        nvpic.setIcon(new ImageIcon("Wizard.gif"));
                        jb6.setEnabled(true);
                    }
                    else if(n==1){
                        nv.setName("Assassin");
                        carreer.setText("      "+ nv.GetCareer());
                        nvpic.setIcon(new ImageIcon("Assassin.gif"));
                        jb6.setEnabled(true);
                    }
                }

                //check coin button
                String NVCarreer=nv.GetCareer();
                if(NVCarreer.equals("Assassin")||NVCarreer.equals("Wizard")){
                    if(myBag.returnCoins()!=0)
                        jb7.setEnabled(true);
                }

                
                //JLabel attacked = new JLabel("ATTACK!!!! ENERMY DOWN!",SwingConstants.CENTER);
                //states.add(attacked);
                
                //c.add(states,BorderLayout.CENTER);

            }
        });
        jb2.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                selectedMonster.setText(" ");
                damage.setText(" ");
                Monster1.setText(" ");
                Monster2.setText(" ");
                Monster3.setText(" ");
                monster1pic.setIcon(new ImageIcon(" "));
                monster2pic.setIcon(new ImageIcon(" "));
                monster3pic.setIcon(new ImageIcon(" "));

                nv.Eatting();
                damage.setText("You've eaten some food HP+100");

                statusLine.setText("STATUS : HP "+nv.GetHP()+" EXP : "+nv.GetEXP()+" CASH : "+nv.GetAttack()+" KILLED : "+nv.GetKill()+" Level : "+nv.GetLevel());
                //statusBag.setText("BAG :: " +myBag.BagsItems() + "/10 : HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                bagsstatus.setText("BAG : "+ myBag.BagsItems()+ " /10 : ");
                goldcointext.setText(" x "+myBag.returnCoins());
                hppotiontext.setText(" x "+myBag.returnHPPotion());
                exppotiontext.setText(" x "+myBag.returnEXPPotion());
            }
        });

        jb3.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                selectedMonster.setText(" ");
                damage.setText(" ");
                Monster1.setText(" ");
                Monster2.setText(" ");
                Monster3.setText(" ");
                monster1pic.setIcon(new ImageIcon(" "));
                monster2pic.setIcon(new ImageIcon(" "));
                monster3pic.setIcon(new ImageIcon(" "));

                nv.Sleeping();
                damage.setText("You've been sleeping for an hour HP+200 EXP-10 ");

                statusLine.setText("STATUS : HP "+nv.GetHP()+" EXP : "+nv.GetEXP()+" CASH : "+nv.GetAttack()+" KILLED : "+nv.GetKill()+" Level : "+nv.GetLevel());
                //statusBag.setText("BAG :: " +myBag.BagsItems() + "/10 : HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                bagsstatus.setText("BAG : "+ myBag.BagsItems()+ " /10 : ");
                goldcointext.setText(" x "+myBag.returnCoins());
                hppotiontext.setText(" x "+myBag.returnHPPotion());
                exppotiontext.setText(" x "+myBag.returnEXPPotion());
            }
        });

        jb4.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                selectedMonster.setText(" ");
                damage.setText("USE HPPotion HP+50 ");
                Monster1.setText(" ");
                Monster2.setText(" ");
                Monster3.setText(" ");
                monster1pic.setIcon(new ImageIcon(" "));
                monster2pic.setIcon(new ImageIcon(" "));
                monster3pic.setIcon(new ImageIcon(" "));

                if(myBag.returnHPPotion()!=0){
                    nv.usingHPPotion();
                    myBag.decreaseItemHPPotion();
                }

                if(myBag.returnHPPotion()==0)
                    jb4.setEnabled(false);
                else
                    jb4.setEnabled(true);

                if(myBag.returnEXPPotion()==0)
                    jb5.setEnabled(false);
                else
                    jb5.setEnabled(true);
                statusLine.setText("STATUS : HP "+nv.GetHP()+" EXP : "+nv.GetEXP()+" CASH : "+nv.GetAttack()+" KILLED : "+nv.GetKill()+" Level : "+nv.GetLevel());
                //statusBag.setText("BAG :: " +myBag.BagsItems() + "/10 : HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                bagsstatus.setText("BAG : "+ myBag.BagsItems()+ " /10 : ");
                goldcointext.setText(" x "+myBag.returnCoins());
                hppotiontext.setText(" x "+myBag.returnHPPotion());
                exppotiontext.setText(" x "+myBag.returnEXPPotion());
            }
        });

        jb5.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                selectedMonster.setText(" ");
                damage.setText("USE EXPPotion EXP+20 ");
                Monster1.setText(" ");
                Monster2.setText(" ");
                Monster3.setText(" ");
                monster1pic.setIcon(new ImageIcon(" "));
                monster2pic.setIcon(new ImageIcon(" "));
                monster3pic.setIcon(new ImageIcon(" "));

                if(myBag.returnEXPPotion()!=0){
                    nv.usingEXPPotion();
                    myBag.decreaseItemEXPPotion();
                }

                if(myBag.returnHPPotion()==0)
                    jb4.setEnabled(false);
                else
                    jb4.setEnabled(true);

                if(myBag.returnEXPPotion()==0)
                    jb5.setEnabled(false);
                else
                    jb5.setEnabled(true);
                statusLine.setText("STATUS : HP "+nv.GetHP()+" EXP : "+nv.GetEXP()+" CASH : "+nv.GetAttack()+" KILLED : "+nv.GetKill()+" Level : "+nv.GetLevel());
                //statusBag.setText("BAG :: " +myBag.BagsItems() + "/10 : HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                bagsstatus.setText("BAG : "+ myBag.BagsItems()+ " /10 : ");
                goldcointext.setText(" x "+myBag.returnCoins());
                hppotiontext.setText(" x "+myBag.returnHPPotion());
                exppotiontext.setText(" x "+myBag.returnEXPPotion());
            }
        });

        jb6.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){

                selectedMonster.setText(" ");
                damage.setText(" ");
                Monster1.setText(" ");
                Monster2.setText(" ");
                Monster3.setText(" ");
                monster1pic.setIcon(new ImageIcon(" "));
                monster2pic.setIcon(new ImageIcon(" "));
                monster3pic.setIcon(new ImageIcon(" "));

                Object[] shops = {"EXPPotion","HPPotion","Close"};
                final ImageIcon iconshop = new ImageIcon(getClass().getResource("shop.gif"));

                int n = JOptionPane.showOptionDialog(c,"EXPPotion : 10 CASH, HPPotion : 5 CASH",
                "SHOP",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,iconshop,shops,shops[2]);
                
               
                    if(n == 0){ // buy EXPPotion
                        
                        if(myBag.BagsItems()<10){
                            nv.paying(10);
                            myBag.increaseEXPPotion();
                            damage.setText("EXPPotion was ADDED");
                        }

                        else if(myBag.BagsItems()>=10){
                            JOptionPane.showMessageDialog(null, 
                                    "DROP SOME ITEMS!!! NO MORE SPACE IN YOUR BAG", 
                                    "BAG FULL!", 
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else if(n==1){ // buy HPPotion
                        if(myBag.BagsItems()<10){
                            nv.paying(5);
                            myBag.increaseHPPotion();
                            damage.setText("HPPotion was ADDED");
                        }
                        else if(myBag.BagsItems()>=10){
                            JOptionPane.showMessageDialog(null, 
                                    "DROP SOME ITEMS!!! NO MORE SPACE IN YOUR BAG", 
                                    "BAG FULL!", 
                                    JOptionPane.WARNING_MESSAGE);
                        }

                    }
                    
                statusLine.setText("STATUS : HP "+nv.GetHP()+" EXP : "+nv.GetEXP()+" CASH : "+nv.GetAttack()+" KILLED : "+nv.GetKill()+" Level : "+nv.GetLevel());
                //statusBag.setText("BAG :: " +myBag.BagsItems() + "/10 : HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                bagsstatus.setText("BAG : "+ myBag.BagsItems()+ " /10 : ");
                goldcointext.setText(" x "+myBag.returnCoins());
                hppotiontext.setText(" x "+myBag.returnHPPotion());
                exppotiontext.setText(" x "+myBag.returnEXPPotion());

            }
        });

        jb7.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                selectedMonster.setText(" ");
                damage.setText(" ");
                Monster1.setText(" ");
                Monster2.setText(" ");
                Monster3.setText(" ");
                monster1pic.setIcon(new ImageIcon(" "));
                monster2pic.setIcon(new ImageIcon(" "));
                monster3pic.setIcon(new ImageIcon(" "));

                Object[] coins = {"YES,SELL IT ","YES, SELLx2","Cancle"};
                final ImageIcon coinsicon = new ImageIcon(getClass().getResource("transfer.gif"));

                int money= rand.nextInt(30);
                int n = JOptionPane.showOptionDialog(c,"DO YOU WANT TO SELL GOLD COIN? (CASH + " + money+" )",
                "TRANSFER",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,coinsicon,coins,coins[2]);

                if(n==0){ // confirm
                    if(myBag.returnCoins()!=0){
                    myBag.decreaseGoldCoin();
                    nv.transferCash(money);}
                }
                if(n==1){
                    if(myBag.returnCoins()>=2){
                        myBag.decreaseGoldCoin();
                        myBag.decreaseGoldCoin();
                        nv.transferCash(money*2);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                    "DON'T HAVE ENOUGH COIN!!!!!", 
                                    "No coin!!", 
                                    JOptionPane.WARNING_MESSAGE);
                    }
                }

                if(myBag.returnCoins()==0)
                    jb7.setEnabled(false);
                else
                    jb7.setEnabled(true);


                statusLine.setText("STATUS : HP "+nv.GetHP()+" EXP : "+nv.GetEXP()+" CASH : "+nv.GetAttack()+" KILLED : "+nv.GetKill()+" Level : "+nv.GetLevel());
                //statusBag.setText("BAG :: " +myBag.BagsItems() + "/10 : HPPotion = " +myBag.returnHPPotion() + " EXPPotion ="+myBag.returnEXPPotion());
                bagsstatus.setText("BAG : "+ myBag.BagsItems()+ " /10 : ");
                goldcointext.setText(" x "+myBag.returnCoins());
                hppotiontext.setText(" x "+myBag.returnHPPotion());
                exppotiontext.setText(" x "+myBag.returnEXPPotion());
            }
        });

        c.add(header,BorderLayout.NORTH);
        c.add(states,BorderLayout.CENTER);
        c.add(button,BorderLayout.EAST);
        c.add(leftsize,BorderLayout.WEST);
        //c.add(pic,BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NoviceGUI();
    }
}