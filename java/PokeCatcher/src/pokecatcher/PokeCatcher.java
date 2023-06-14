
package pokecatcher;

/**
 *
 * @author David
 */
public class PokeCatcher {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Ball b1 = new Ball();
        Pokemon p1 = Generator.genPoke();
        System.out.println(p1);
        
    }
    
}
