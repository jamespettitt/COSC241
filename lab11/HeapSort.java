package week11;;

/**
 * Provides a way of running Heap sorting algorithms.
 * extends the sort class
 *@author James Pettitt.
 */
public class HeapSort extends Sorter{
    /**
     * create a new selection sort sorter with given integers to sort.
     *@param nums the integers to sort.
     */

    public HeapSort(Integer[] nums){
        super(nums); //pass nums[] to the superclass Sort
    }

    /**
     *required method, calls heapify from a loop,
     *to build the heap. elements are extracted from
     *the heap and moved into an array, then heapified again
     *results in sorted heap.
     */
    public void sortNums(){
        int n = nums.length;
        for(int i = n/2 -1; i >= 0; i--){
            heapify(nums, n, i);
        }

        for(int i = n-1; i>=0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
            update();
        }
    }
    /**
     *heapify method heapifies trees with root node i,
     * also an index in nums array.
     *@param nums array of ints to heap
     *@param n represents array size
     *@param i represents index of subtree node
     **/
    private void heapify(Integer[] nums, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < n && nums[right] > nums[largest]){
            largest = right;
        }

        if(largest != i){
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            heapify(nums, n, largest);
        }

    }
    
}
