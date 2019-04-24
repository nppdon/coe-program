import java.io.*;
import java.util.*;

public class Novice
{
    private int hp;
    private int exp;
    private int attack;
    private int killed;
    private int level;
    private String carreername;

    Bag bg = new Bag();

    public int GetHP()
    {
        return hp;
    }
    public int GetEXP()
    {
        return exp;
    }
    public int GetAttack()
    {
        return attack;
    }
    public int GetKill(){
        return killed;
    }
    public String GetCareer(){
        return carreername;
    }
    public int GetLevel(){
        return level;
    }
    public Novice()
    {
        hp=300;
        exp=0;
        attack=10;
        killed=0;
        level = 1;
        carreername = "Novice";
    } 
    
    public void AttackEnemies(int damage)
    {
        hp = hp - damage;
        exp = exp + 10;
        attack = attack + 5;
        killed=killed+1;
    }
    public void AssassinAttack(){
        hp = hp - 20;
        exp = exp+15;
        attack = attack +10;
    }
    public void WizardAttack(){
        hp = hp - 30;
        exp= exp+25;
        attack = attack+10;
    }

    public void Eatting()
    {
        hp=hp+100;
    }

    public void Sleeping()
    {
        hp=hp+200;
        exp=exp-10;
    }
    public void usingHPPotion()
    {
        hp=hp+bg.useHPPotion();
    }
    public void usingEXPPotion()
    {
        exp=exp+bg.useEXPPotion();
    }
    public void setHP(int newhp)
    {
        hp = newhp;
    }
    public void setEXP(int newexp)
    {
        exp = newexp;
    }
    public void setAttack(int newattack)
    {
        attack=newattack;
    }
    public void setName(String newname)
    {
        carreername = newname;
    }
    public void setLevel(){
        level=level+1;
    }
    public void paying(int payment){
        attack = attack-payment;
    }
    public void transferCash(int cash){
        attack= attack+cash;
    }
}