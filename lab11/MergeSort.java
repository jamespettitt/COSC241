package week11;
/**
 * Provides a way of running Merge sorting algorithms.
 * extends the sort class
 *@author James Pettitt.
 */
public class MergeSort extends Sorter{
    /**
     * create a new selection sort sorter with given integers to sort.
     *@param nums the integers to sort.
     */

    public MergeSort(Integer[] nums){
        super(nums); //pass nums[] to the superclass Sort
    }

    /**
     *Sort the integers , which are stored in parent Sorter class.
     *calls mergeSort
     */
    public void sortNums(){
        int left = 0;
        int right = (nums.length) - 1;

        mergeSort(left, right);
    }

    
    /**sorts given array by splitting the array,
     * sorting the pieces and merging together.
     *
     *@param left leftmost point of array
     *@param right rightmost point of array
     **/
    public void mergeSort(int left, int right){
        if (left<right){
            int mid = (left + right)/2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid + 1, right);
        }
    }

    /**
     *merges the two subarrays into one.
     *
     *@param mid represents middle of array
     *@param left leftmost point of array
     *@param right rightmost point of array
     **/
    private void merge(int left, int mid, int right){
        Integer[] temp = new Integer[nums.length];
        for(int i = 0; i < temp.length; i++){
            temp[i] = nums[i];
        }
        int i = left;
        int j = left;
        int k = mid;

        while(i < mid && k <= right){
            if (temp[i] < temp[k]){
                nums[j++] = temp[i++];
            } else{
                nums[j++] = temp[k++];
            }
        }
        while ( i < mid ) {
            nums[j++] = temp[i++];
        }

        while (j <= right){
            nums[j++] = temp[k++];
        }
        update();
    }
}
