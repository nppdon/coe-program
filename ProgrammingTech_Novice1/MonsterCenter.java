import java.util.ArrayList;

public class MonsterCenter {
    private ArrayList<Monster>Monsters;

    public MonsterCenter(){
        Monsters= new ArrayList< Monster >();
    }

    public void add(Monster m){
        Monsters.add(m);
    }
    public String PrintInfo(int num){
        Monster m = Monsters.get(num);
        String Info = "MONTER"+(num+1)+m;
        return Info;
    }
    public String PrintDamage(int num){
        Monster m = Monsters.get(num);
        String Info = "MONSTER"+(num+1)+m+"DAMAGE TO YOU : HP -"+m.GetDP();
        return Info;
    }
    public int getMonsterHP(int num){
        Monster m = Monsters.get(num);
        int hp = m.GetHP(); 
        return hp;
    }
    public int getMonsterDP(int num){
        Monster m = Monsters.get(num);
        int dp = m.GetDP(); 
        return dp;
    }
    public void removeMonster(){
        for(int i=0;i<3;i++){
            Monsters.remove(i);
        }
    }
}