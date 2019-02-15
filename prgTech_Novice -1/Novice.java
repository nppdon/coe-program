import java.io.*;
import java.util.*;

public class Novice
{
    private int hp;
    private int exp;
    private int attack;

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
    public Novice()
    {
        hp=300;
        exp=0;
        attack=10;
    } 
    
    public void AttackEnemies()
    {
        hp = hp - 50;
        exp = exp + 10;
        attack = attack + 5;
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
    public void usingPotion()
    {
        hp=hp+bg.usePotion();
    }


}