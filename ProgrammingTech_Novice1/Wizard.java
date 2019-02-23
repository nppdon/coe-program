import java.io.*;

public class Wizard extends Novice{

    public void setWizard (int newhp, int newexp, int newattack ){
        super.setHP(newhp+50);
        super.setEXP(newexp+5);
        super.setAttack(newattack+10);
        super.setName("Wizard");
    }
}
