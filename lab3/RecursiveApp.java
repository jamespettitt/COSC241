/**
 * James Pettitt
 * Lab3
 */
package week03;
/**determines the number of digits and determines the sum.
 *@author James Pettitt
 */
public class RecursiveApp{
 
    /**main method initialises and calls the methods.
     *@param args command lines are not used
     */
    public static void main(String[] args){
    }
    /**returns number of digits in argument.
     *@return count returns a long equal to the digits in the argument.
     *@param n = long number 
     */
    public static long digits(long n){
        long count = 1;
        if (n < 10){
            count = 1;
        }else if(n > 10){
            count = 1 + digits( n / 10);
        }
        return count;
    }
    /** finds the sum of the digits in a long number.
     *@param n = long number input to find the sum of.
     *@return returns the sum of the digits in n.
     */
    public static long sumOfDigits(long n){
        long ans = 0;
        if (n != 0){
            ans = n % 10 + sumOfDigits( n / 10);
        }
        return ans;          
    }
}
