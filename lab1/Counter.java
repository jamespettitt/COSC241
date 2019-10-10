/**
*James Pettitt, 2018
*Counter.java
*Lab 01
**/
package week01;
import java.util.Scanner;

/**
* has main method and asks for input and prints info.
*@author James Pettitt
**/
public class Counter {
    /**
    *Method asks for inputs from user and prints out how many.
    *words and lines there are
    *@param args Commandline argument.
    **/
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int wordCount = 0;
        int lineCount = 0;
       
        while(input.hasNextLine()){
            lineCount++;
            String line = input.nextLine();
            Scanner sl = new Scanner(line);
           
            while(sl.hasNext()){
                wordCount++;
                sl.next();
            }
       
        }
       
        System.out.println("lines: " + lineCount);
        System.out.println("words: " + wordCount);
    }
}
