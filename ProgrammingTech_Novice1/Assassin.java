import java.io.*;

public class Assassin extends Novice{

    public void setAssassin(int newhp, int newexp, int newattack ){
        super.setHP(newhp+50);
        super.setEXP(newexp+20);
        super.setAttack(newattack+50);
        super.setName("Assassin");
    }


}