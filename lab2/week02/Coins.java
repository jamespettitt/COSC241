/**Coins.java
 * James Pettitt
 * LAB 2
 */
 
package week02;
import java.util.Random;
 
/**returns whether a coin is heads or tails.
 *@author James Pettitt
 */
public class Coins{
    /**boolean makes heads true. */
    public static final boolean HEADS = true;
    /** boolean makes tails false. */
    public static final boolean TAILS = false;
    /** creates boolean array for coins. */
    private boolean[] coins;
 
    /**
     * @param args command lines are not used.
     */
    public static void main(String[] args){
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        Coins d = new Coins(b);
        System.out.println(c.countHeads());
        System.out.println(d.toString());
    }
   
    /**constructor for coins array
     * @param coins variable is array name.
     */
    public Coins(boolean[] coins){
        this.coins = coins;
    }
   
    /**returns the count of heads.
     *@return count of heads.
     */
    public int countHeads(){
        int count = 0;
        for(int index=0; index<coins.length; index++){
            if(coins[index]){
                count++;
            }
        }
        return count;
    }
    /**displays the result of the coins toss.
     *@return 'T' or 'H' for heads or tails.
     */
    public String toString(){
        String s = "";
        for(int index = 0; index < coins.length; index++){
            if(coins[index]){
                s += "H";
            }
            else{
                s += "T";
            }
        }
        return s;
    }
   
    /**creates a coin object depending on outcome of tosses.
     *@param c parameter for a coin object.
     */
    public Coins(String c){
        coins = new boolean[c.length()];
       
        for(int index=0; index < coins.length; index++){
            if (c.charAt(index) == 'H'){
                coins[index] = HEADS;
            }
            else if (c.charAt(index) == 'T'){
                coins[index] = TAILS;
            }
        }
    }
    /**makes a Coins object consisting of a series of random toss.
     *@param length int variable.
     */
    public Coins(int length){
        coins = new boolean[length];
        Random r = new Random();  
       
        for(int i = 0; i<coins.length; i++){
            int num = r.nextInt(2);
            if(num == 0){
                coins[i] = HEADS;
            }
            else if(num == 1){
                coins[i] = TAILS;
            }
        }
    }
   
    /**
     *returns number of runs in a sequence.
     *@return the number of runs
     */
    public int countRuns(){
        int runs = 1;
        for(int index = 1; index < coins.length; index++){
            if(coins[index-1] != coins[index]){
                runs++;
            }
        }
        return runs;
    }
}
