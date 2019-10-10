package week07;

import java.util.*;
import java.io.*;

/**frequency generator.
 *@author James Pettitt 2019.
 */

public class FrequencyGenerator implements WordGenerator {
    /**final size.*/
    private final int size = 26;
    /** random.*/
    private Random random;
    /**array.*/
    private double[] w;

    /** main method.
     *@param args command line arguments are not used.
     */
    public static void main(String[] args){
        FrequencyGenerator f = new FrequencyGenerator(new Random());
    }

    /**scans in file and reads it.
     * @param r random r object
     */
    public FrequencyGenerator(Random r) {
        File file;
        try{
            file = new File("letter-frequencies.txt");
            Scanner s = new Scanner(file);
            w = new double[size];
            for(int index = 0; index < w.length; index++){
                w[index] = s.nextDouble();
            }
        }catch(Exception e){}


        random = r;
    }
    /**method gets the next integer.
     *@param n input.
     *@return next word.
     */
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<n; i++){
            char c = (char) ('a' + chooseIndex());
            result.append(c);
        }
        return result.toString();
    }

    /**chooses index.
     *@return returns index.
     */
    public int chooseIndex(){
        int index = 0;
        double ranNum = random.nextDouble();
        while (ranNum > w[index]){
            ranNum = ranNum - w[index];
            index++;
        }
        return index;
    }
}
