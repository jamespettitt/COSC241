package week10;
import java.util.*;

/**
 *this class has several methods, some that operate on the pile made,
 *and some that only return specific values at index in the pile.
 *
 *this method implements the ExamPile class also found in the package.
 *
 *@author James Pettitt, ID: 4713804, COSC241, 2018.
 **/
public class EP implements ExamPile{

    /**creates an exam pile, of type linked list, expecting integers. **/
    LinkedList<Integer> pile = new LinkedList<Integer>();
 
    /**
     *this method initialises the newly created exam pile and.
     *fills it with the contents of the array given to the methid
     *
     *@param items an array that holds the content of an exam pile
     **/
    public void load(int[] items){
        //for loop goes through the exam
        //adding each item to the pile list
        for(int item:items){
            pile.add(item);
        }
    }

    /**
     *this method returns the number of exams.
     *that remain in the exam pile
     *
     *@return int the size of the exam pile
     **/
    public int size(){
        return pile.size();
    }
 
    /**
     *this method returns the value that is at.
     *the top of the pile
     *
     *@return int the value at the top of the pile
     **/
    public int peek() {
        try {
            return pile.peek();
        } catch (EmptyPileException e) {
            throw new EmptyPileException("The exam pile is an empty");
        }
    }

    /**
     *this method returns an int value from the thing at the top.
     *of the pile, and removes that value from the pile
     *
     *@return int the value at the top of the pile
     **/
    public int mark(){
        try {
            return pile.poll();
        } catch (EmptyPileException e) {
            throw new EmptyPileException("The exam pile is an empty");
        }
    }
    /**
     *this method moves the value from the top.
     *to the bottom of the pile
     **/
    public void delay(){
        try {
            pile.add(pile.removeFirst());
        } catch (EmptyPileException e) {
            throw new EmptyPileException("The exam pile is an empty");
        }
    }

    /**
     *this method prints out everything contained in the pile.
     *on one line, separated by a space
     *
     *@return finalString everything in the pile
     **/
    public String toString(){
        String finalString = "";
        //for loop goes through each exam, adding the value
        //to the string that is outputted
        for(Integer s : pile){
            finalString += s + " ";
        }
        return finalString.substring(0,finalString.length()-1);
    }

    /**
     *this method uses 2 exam piles and checks whether.
     *their data is the same, and therefor they are
     *the same pile
     *
     *@param pile2 an EP that can be used to compare
     *whether or not the 2 piles are the same
     *
     *@return true if pile and pile are equal
     **/
    public boolean equals(EP pile2){
        return pile2.pile.equals(pile);
    }

    /**
     *this method uses the exam pile to create.
     *a string of steps that can tell us whether to  mark
     *an exam, or whether to delay and try and
     *mark the next one
     *
     *@return s a String in the form of D's and M's
     *that has been created depending on the exampile
     **/
    public String sortingSteps(){
        String s = "";
        int index = 0;

        //while loop repeates until the pile is empty
        //i.e every exam is marked
        while (pile.size() > 0){
            //adds an M if the peek is the same as index
            //i.e the exam needs to be marked
            if(pile.peek() == index){
                mark();
                s += "M";
                index++;
            } else { //otherwise, the exam doesn't need to be marked
                delay();
                s += "D";
            }
        }
        return s;
    }

    /**
     *this method accepts a parameter of steps and.
     *reconstructs the pile from these steps. the string  will
     *be in the form of D's and M's
     *
     *@param steps a string in form of D's and M's
     *
     *@return pile2 an EP reconstructed
     **/
    public static EP reconstruct(String steps){
        //initialises a new exam pile
        EP pile2 = new EP();

        //turns the string passed to the method into an array of char's
        char[] letters = steps.toCharArray();

        int mCount = 0;

        //for loop counts how letters are M
        //i.e the amount of exams to mark
        for(char c : letters){
            if(c == 'M'){
                mCount++;
            }
        }
        
        mCount--;

        //
        for(int i = letters.length - 1; i >= 0; i--){
            if(letters[i] == 'M'){
                pile2.pile.add(0, mCount);
                mCount--;
            } else {
                int last = pile2.pile.remove(pile2.pile.size() - 1);
                pile2.pile.add(0, last);
            }
        }
        
        return pile2;
    }    
}//class

