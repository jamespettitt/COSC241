package week10;

import java.util.*;

/**interface ExamPile which will be extended by EP.java.
 * this interface encapsulations the state information
 * that EP will need to create and modify new exam piles
 *
 *@author James Pettitt, 2018
 *@author Iain Hewson
 **/
public interface ExamPile{
    /**Initialises the pile of exams.
    * to consist of the contents
    * of the array items.
    *
    *@param items the array provided that holds
    * the contens to fill the exam pile
    **/
    public void load(int[] items);
    
    /**returns the number of exams in the pile.
    *
    *@return size the number of exams in the pile
    **/
    public int size();

    /**returns the value at the top of the pile.
    *
    *@return the value at the top of the pile
    **/
    public int peek();

    /**returns the value at the top of the pile.
    * and removes it from the pile.
    *
    *@return the value at the top of the pile
    **/
    public int mark();

    /**moves the value from the top of the pile.
    * to the bottom of the pile.**/
    public void delay();
}
