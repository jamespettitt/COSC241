package week07;

import java.io.*;
import java.util.*;

/**creates a digram generator.
 *@author James Pettitt 2019.
 */
public class DigramGenerator implements WordGenerator {
    /**set random.*/
    private Random random;

    /**sets the str letters.*/
    private String letters;

    /**lettersArray.*/
    private String[] lettersArr;
    /**alphabet size . final.*/
    private final int alphSize = 26;

    /**method of digram generator.
     *@param r is random object.
     */
    public DigramGenerator(Random r) {
        random = r;
        File firstLetters;
        File continuations;
        try {
            firstLetters = new File ("first-letters.txt");
            Scanner s = new Scanner (firstLetters);
            letters = s.nextLine();
        }catch(Exception e){}
        lettersArr = new String[alphSize];

        try{
            continuations = new File("continuations.txt");
            Scanner s2 = new Scanner (continuations);
            for(int i = 0; i <lettersArr.length; i++){
                lettersArr[i] = s2.nextLine();
            }
            int i = 0;
        }catch(Exception p){}
    }

    /**method produces next word.
     *@param n is an int input.
     *@return returns next word.
     */
    public String nextWord(int n) {
        char secLetter;
        String sentence;
        StringBuilder result = new StringBuilder();
        int charIndex = random.nextInt(letters.length());
        char firstLetter = letters.charAt(charIndex);
        result.append(firstLetter);

        for(int i = 1 ; i<n ; i++){
            sentence = lettersArr[firstLetter - 'a'];
            secLetter = randChar(sentence);
            result.append(secLetter);
            firstLetter = secLetter;
        }
       

        
        return result.toString();
    }

    /**method finds rand char.
     *@return returns the random char.
     *@param s is the random str input.
     */
    private char randChar(String s){
        return s.charAt(random.nextInt(s.length()));
    }
}
