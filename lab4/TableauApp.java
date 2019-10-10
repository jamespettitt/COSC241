package week04;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        //final int[][] p = {};
        System.out.println(TableauApp.toString(valid));
        System.out.println(TableauApp.rowLengthsDecrease(valid));
        System.out.println(TableauApp.rowValuesIncrease(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if(rowLengthsDecrease(t) && rowValuesIncrease(t) && 
            columnValuesIncrease(t) && isSetOf1toN(t) ){
            return true;
        }
        return false;

    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }





    /**
     *  Returns whether or not the row lengths decrease.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return true if the row lengths decrease, otherwise false.
     */
    public static boolean rowLengthsDecrease (int[][] t) {
        for(int i = 1; i < t.length; i++) {
            if(t[i].length > t[i-1].length){
                return false;
            }
        }
        return true;
    }




    /**
     *  Returns whether or not the row values increase.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return true if the row values increase, otherwise false.
     */
    public static boolean rowValuesIncrease(int[][] t){
        for(int row = 0; row < t.length-1; row++) {
            for(int column = 0; column < t[row].length-1; column++){

                int currentInt = t[row][column];
                int nextInt = t[row][column+1];

                if(currentInt > nextInt) {
                    return false;
                } 
            }
        }
        return true;
    }




    /**
     *  Returns whether or not the column values.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return true if the column values increase, otherwise false.
     */
    public static boolean columnValuesIncrease(int[][] t) {
        for(int row = 1; row < t.length-1; row++){

            for(int col = 0; col < t[row].length; col++){

                int currentInt = t[row-1][col];
                int nextInt = t[row][col];
            
                if(currentInt > nextInt){
                    return false;
                }
            }
        }
        return true;
    }
    














    /**
     *  Returns whether or not number of cells is equal to n.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return true if the number of cells is equal to n, otherwise false.
     */
    public static boolean isSetOf1toN(int[][] t){
        int n = 0;
        
        //counts the amount of boxes
        for(int row = 0; row < t.length; row++){ 
            for(int col = 0; col < t[row].length; col++){
                n++;
            }
        }

        //creates new boolean array
        boolean[] checkNums = new boolean[n];
      
        //sets every element to false
        for(boolean f : checkNums) {
            f = false;
        }
  
        //sets checkNum boxes to true if it's okay tablaeu
        for(int g = 1; g <= n; g++){
            for(int row = 0; row < t.length; row++){
                for(int col = 0; col < t[row].length; col++){
                    if( g == t[row][col]) {
                        checkNums[g-1] = true;
                    }
                }
            }
        }
        
        //checks if any elements in checkNums are false
        for(int a = 0; a < checkNums.length; a++){
            if(!(checkNums[a])){
                return false;
            }
        }

        return true;

    }



}
