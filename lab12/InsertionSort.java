package week12;

/**
 *  An insertion sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class InsertionSort extends Sorter {

    /**
     *  Create a new InsertionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using insertion sort.
     */
    public void sortNums() {
        comparisons = 0;
        int key = 0;
        for (int i = 1; i < nums.length; i++){
            key = nums[i];
            j = i-1;

            while(j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j=j-1;
                comparisons++;
            }
            nums[j+1] = key;
        }
        update();
    }

}
