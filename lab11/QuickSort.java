package week11;

/**
 * Provides a way of running Quick  sorting algorithms.
 * extends the sort class
 *@author James Pettitt.
 */
public class QuickSort extends Sorter{
    /**
     * create a new selection sort sorter with given integers to sort.
     *@param nums the integers to sort.
     */

    public QuickSort(Integer[] nums){
        super(nums); //pass nums[] to the superclass Sort
    }

    /**
     *Sort the integers , which are stored in parent Sorter class.
     
     */
    public void sortNums(){
        int left = 0;
        int right = (nums.length) - 1;

        quickSort(left, right);
    }

    /**selecting a pivot, anything smaller
     *than the pivot  the left, and anything
     * equal or larger on the right.
     *
     *@param left leftmost point of array
     *@param right rightmost point of array
     **/
    public void quickSort(int left, int right){
        if (left<right){
            int p  = partition(left, right);
            quickSort(left, p);
            quickSort(p + 1, right);
            update();
        }
    }

    /**aux method that modifies array and returns hole.
     *@param left leftmost point of array
     *@param right rightmost point of array
     *@return hole, p in quicksort, represents the pivot index
     **/
    private int partition(int left, int right){
        int pivot = nums[left];
        int hole = left;
        int i = left + 1;
        int j = right;

        while(1 > 0){
            while( j < hole && nums[j] >= pivot){
                j--;
            }

            if (j == hole) {
                break;
            }

            nums[hole] = nums[j];
            hole = j;
            while( i < hole && nums[i] < pivot){
                i++;
            }
            if ( i == hole){
                break;
            }
            nums[hole] = nums[i];
            hole = i;
        }
        nums[hole] = pivot;
        update();
        return hole;
    }
}
