 /**MERGE SORT**/

public void sortNums(){
  int left = 0;
  int right = (nums.length)-1;
  mergeSort(left, right);
}

public void mergeSort(int left, int right){
  if(left < right){
    int mid = (left + right)/2;
    mergeSort(left, mid);
    mergeSort(mid+1, right);
    merge(left, mid+1, right);
  }
}

private void merge(int left, int mid, int right){
  Integer[] temp = new Integer[nums.length];
  for(int i = 0; i < nums.length; i++){
    temp[i] = nums[i];
  }
  
  int i = left;
  int j = left;
  int k = mid;
  
  while(i < mid && k <= right){
    if(temp[i] < temp[k]){
      nums[j++] = temp[i++];
    } else{
      nums[j++] = temp [k++];
    }
  }
  
  while (i < mid){
    nums[j++] = temp[i++];
  }
  
  while (j <= right) {
    nums[j++] = temp[k++];
  }
  
  update();
 
}

///////////////////////////////////////////////////////////////////////////////////////////////

/**QUICK SORT**/

public void sortNums(){
  int left = 0;
  int right = (nums.length)-1;
  mergeSort(left, right);
}

public void quickSort(int left, int right){
  if(left < right){
    int p = partition(left, right);
    quickSort(left, p);
    quickSort(p+1, right);
    update();
  }
}

private int partition(int left, int right){
  int pivot = nums[left];
  int hole = left;
  int i = left + 1;
  int j = right;
  
  while(1 > 0){
    while (j > hole && nums[j] >= pivot){
      j--;
    }
    
    if(j == hole){
      break;
    }
    
    nums[hole] = nums[j];
    hole = j;
    
    while( i < hole && nums[i] < pivot){
      i++;
    }
     
    if(i == hole){
      break;
    }
    
    nums[hole] = nums[i];
    hole = i;
  }
  
  nums[hole] = pivot;
  return hole;
}