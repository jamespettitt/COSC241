package week09;

/**
 * Provides a way of running Insertion sorting algorithms.
 * extends the sort class
 *@author James Pettitt.
 */
public class SelectionSort extends Sorter{
    /**
     * create a new selection sort sorter with given integers to sort.
     *@param nums the integers to sort.
     */

    public SelectionSort(Integer[] nums){
        super(nums); //pass nums[] to the superclass Sort
    }

    /**
     *Sort the integers , which are stored in parent Sorter class.
     
     */
    public void sortNums(){
        //int i , j , comparisons and num[] are all protected dfields in
        //the superclass Sort so we can use them without declaring them
        
        for(i = 0; i < nums.length; i++){
            j = i;
            for( int y = i + 1; y < nums.length; y++){
                if(nums[y] < nums[j]){
                    j = y;
                    comparisons++;
                }
            }
            
            int smallerNumber = nums[j];
            nums[j] = nums[i];
            nums[i] = smallerNumber;
            
            
            
        }
        
        update();
    }
}
