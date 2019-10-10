package week11;;

/**
 * Provides a way of running Insertion sorting algorithms.
 * extends the sort class
 *@author James Pettitt.
 */
public class InsertionSort extends Sorter{
    /**
     * create a new selection sort sorter with given integers to sort.
     *@param nums the integers to sort.
     */

    public InsertionSort(Integer[] nums){
        super(nums); //pass nums[] to the superclass Sort
    }

    /**
     *Sort the integers , which are stored in parent Sorter class.
     
     */
    public void sortNums(){
        //int i , j , comparisons and num[] are all protected dfields in
        //the superclass Sort so we can use them without declaring them
        comparisons = 0;
        int key = 0;

        for(i = 1 ; i < nums.length; i++){
            key = nums[i];
            j = i-1;

            while (j>= 0 && nums[j] > key){
                nums [j+1] = nums[j];
                j = j-1;
                comparisons++;
            }
            nums[j+1] = key;
        }
        update();
    }
}
