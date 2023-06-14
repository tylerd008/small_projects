
package pokecatcher;

/**
 *
 * @author David
 */
public class Pokemon {
    private double HP, MHP, CRate;//Current HP, Max HP, Catch Rate
    private final String name;//Name
    private String stringForm;//toString output
    
    public Pokemon(String Name, double CRate, double HP){
        this.HP = HP;
        this.MHP = HP;
        this.name = Name;
        this.CRate = CRate;
    }
    
    public void takeDamage(double Damagedealt){
        System.out.println(name+" took "+(int)Damagedealt+" damage!");
        HP -= Damagedealt;
        if (HP < 0)
            HP = 0;
    }
    
    public int getCurrentHP(){
        return (int)HP;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMaxHP(){
        return (int)MHP;
    }
    
    public double getCatchRate(){
        return CRate;
    }
    
    public String toString(){
        stringForm = name+" has "+HP+" HP remaining out of a max of "+MHP+".\n"+name+ " has a catch rate of "+CRate+"\n";
        return stringForm;    
    }
}
