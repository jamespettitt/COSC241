package week12;

/**
 *  A heap sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class HeapSort extends Sorter {

    /**
     *  Create a new HeapSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using heap sort.
     */
    public void sortNums() {
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

    private void swap(int x, int y) {
        // int i, j, and nums[] are all protected datafields in the
        // superclass Sort so we can use them without declaring them
        i = x;
        j = y;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        update();
    }

    /**
     *  Turn this into a heap by sifting down each value that isn't
     *  already a leaf.
     */
    private void heapify(Integer[] nums, int n, int i) {
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


    /**
     *  Move the value at index i down in the heap to its correct
     *  place by continually swapping it with its largest child that
     *  is bigger than it.
     *
     * @param i the index of the value to be sifted down in the heap.
     * @param size the size of the current heap (will be smaller than
     *        array length as heap sort is performed).
     */
    private void siftDown(int i, int size) {
        
    }

    /**
     *  Returns the index of the largest child of i, or -1 if i
     *  doesn't have a child larger than itself.
     *
     * @return the index of i's largest child that is bigger than i or
     *         -1 if no such child exists.
     */
    private int getLargerChildIndex(int i, int size) {
        return -1;
    }
    
}
