package week12;

/**
 *  A merge sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class MergeSort extends Sorter {

    /** Second array used for merge sorting. */
    private Integer[] tempMergArr;

    /**
     *  Create a new MergeSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
        super(nums);
        tempMergArr = new Integer[nums.length];
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using merge sort.
     */
    public void sortNums() {
        int left = 0;
        int right = nums.length-1;
        mergeSort(left, right);
    }

    public void mergeSort(int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid + 1, right);
        }
    }

    public void merge(int left, int mid, int right){
        Integer[] temp  = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }

        int i = left;
        int j = left;
        int k = mid;

        while ( i < mid && k <= right ){
            if (temp[i] < temp[k]){
                nums[j++] = temp[i++];
            } else {
                nums[j++] = temp[k++];
            }
            
        }

        while ( i < mid ) {
            nums[j++] = temp[i++];
        }
        while ( j <= right ) {
            nums[j++] = temp[k++];
        }
        
    }
    
}
