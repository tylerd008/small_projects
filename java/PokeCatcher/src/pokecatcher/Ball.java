
package pokecatcher;
import java.util.Random;

/**
 *
 * @author David
 */
public class Ball {
    private Random rand = new Random();
    private double modcatchRate, shakeProb; //Modified catch rate & shake probility
    private int shakecompNum, shakeNum = 0; // Number shakeprob is compared to & number of shakes
    private boolean shake = true, shakeb = true; //Shake? & Shake break
    
    public Ball(){
    
    }
    private void calccatchRate(double pCatch, double MHP, double CHP, double status, double ballBonus){
      modcatchRate = ((3*MHP-2*CHP)*pCatch*ballBonus*status)/(3*MHP);
    }
    private void shakeProb(){
        shakeProb = Math.floor(65536/(Math.pow(255/modcatchRate, .1875)));
    }
    public double getcatchRate(){
        return modcatchRate;
    }
    private boolean shakeCheck(){
        shakecompNum = rand.nextInt(65536);
        if (shakecompNum >= shakeProb)
            shake = false;
        else
            shake = true;                    
        return shake;
    }
    public void throwBall(double pCatch, double MHP, double CHP, double status, double ballBonus, String Name) throws InterruptedException{
        while (shakeb == true && shakeNum < 4){
            calccatchRate(pCatch, MHP, CHP, status, ballBonus);
            shakeProb();
            shakeb = shakeCheck();
            if (shakeb == true){
                shakeNum++;
                if (shakeNum < 4 )
                    System.out.println(shakeNum);
                else{
                    System.out.println("Gotcha! "+Name+" was caught!");
                    
                }
                Thread.sleep(1000);
            }
            else{
                switch(shakeNum){
                    case 0: 
                        System.out.println("Oh no! The Pokémon broke free!");
                        shakeb = false;
                        break;
                    case 1:
                        System.out.println("Aww, it appeared to be caught!");
                        shakeb = false;
                        break;
                    case 2:
                        System.out.println("Aargh! Almost had it!");
                        shakeb = false;
                        break;
                    case 3:
                        System.out.println("Gah! It was so close too!");
                        shakeb = false;
                        break;
                    default:
                        System.out.println(">.>\nNice going.");
                }
            }
        }
        shakeb = true;
        shakeNum = 0;
    }
}
