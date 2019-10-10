public static boolean rowLengthsDecrease(int[][] t) {
  int prevRowLength = t[0].length;
  for (int row = 0; row < t.length; i++){
    if (t[row].length >  prevRowLength){
      return false;
    }
    prevRowLength = t[row].length; 
  }
  return true; 
}

///////////////////////////////////////////////////////////////////////////////////////////////

public static boolean rowValuesIncrease(int[][] t){
  int prevValue = t[0][0];
  for (int row = 0; row < t.length; row++){
    for (int col = 0; col < t[row].length; col++){
      if (prevValue > t[row][col]){
        return false;
      }
      prevValue = t[row][col];
    } 
    prevValue = t[row][0];
  }
  return true;
}

///////////////////////////////////////////////////////////////////////////////////////////////

public static boolean columnValuesIncrease(int[][] t){
  for (int col = 0; col < t[0].length; col ++){
    for (int row = 0; row < t.length-1; row++){
      if (col < t[row].length && col < t[row+1].length && t[row+1][col] < t[row][col]){
        return false;
      }
    }
  }
  return true;
}

///////////////////////////////////////////////////////////////////////////////////////////////

public static boolean isSetOf1toN(int[][] t){
  int cellCount = 0;
  int n = 0;
  for (int row=0; row<t.length; row++){        //for every row
    for (int col = 0; col < t[row].length; col++){       //for every column 
      
      cellCount ++;     //counts num of cells
      
      if (t[row][col] > n){
        t[row][col] = n;
      } else if (t[row][col] == n){
        return false;
      }
      
    }
  }
  return n == cellCount;
}