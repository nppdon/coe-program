import java.util.Random;

public class Monster {

    private int monsterHP,damagePoint;

    Random rand = new Random();

    public Monster(){
        monsterHP = rand.nextInt(100);;
        damagePoint = rand.nextInt(monsterHP);
    }
    public String toString(){
        String monsterInfo = " HP : "+monsterHP;
        return monsterInfo;
    }
    public int GetHP(){
        return monsterHP;
    }
    public int GetDP(){
        return damagePoint;
    }
    
}