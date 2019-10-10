package week12;

/**
 *  A selection sort implementation which is able to be observed through
 *  its Sorter superclass.
 *
 * @author Iain Hewson
 */
public class SelectionSort extends Sorter {
    
    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using selection sort.
     */
    public void sortNums() {
        for(i = 0; i < nums.length; i++){
            j = i ;
            for(int y = i+1 ; y < nums.length; y++){
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
