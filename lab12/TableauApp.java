package week12;

/**
 *  Practical test 2 - Part A
 *
 *  An array based implementation of Young's tableau.
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
        System.out.println(TableauApp.toString(valid));
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        return rowLengthsDecrease(t) && rowValuesIncrease(t) &&
            columnValuesIncrease(t) && isSetOf1toN(t);
    }

    /**
     *  Returns a string representation of a tableau.
     *
     * @param t a two-dimensional array which should be a tableau.
     *
     * @return a string representation of a tableau.
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
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean rowLengthsDecrease(int[][] t) {
        int prevRowLength = t[0].length;
        for(int row = 0; row < t.length; row++){
            if(prevRowLength < t[row].length){
                return false;
            }
            prevRowLength = t[row].length;
        }
        return true;
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean rowValuesIncrease(int[][] t) {
        int prevValue = t[0][0];
        for(int row = 0; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){
                if(prevValue > t[row][col]){
                    return false;
                }
                prevValue = t[row][col];
            }
            prevValue = t[row][0];
        }
        return true;
    }
    

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean columnValuesIncrease(int[][] t) {
        for( int col = 0; col < t[0].length; col++){
            for(int row = 0; row < t.length-1; row++){
                if(col < t[row].length && col < t[row+1].length && t[row+1][col] < t[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isSetOf1toN(int[][] t) {
        int cellCount = 0;
        int n = 0;
        for(int row = 0; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){
                cellCount++;

                if(t[row][col] > n){
                    n = t[row][col];
                } else if ( n == t[row][col]){
                    return false;
              }
            }
        }
        return n == cellCount;
    }
}
