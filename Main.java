/*
Start by reading the numbers for sudoku from a file.
Used the Characteristic Vector to check if each number appears only once on each line and each column .
Return true if the sudoku is correctly solved. Otherwise return false if one of the conditions is not satisfied or if the sudoku is wrong.
*/

/**
 *  Check if a Sudoku is correctly solved. Implement a function that receives a 9 by 9 matrix of integers and returns true or false.
 *
 * @author Adrian Katana
 */

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Sudoku());
    }

    private static boolean Sudoku() {

        int[][] matrix = new int[9][9]; //Matrix with the numbers for sudoku
        int[] array = new int[10]; //Characteristic vector
        boolean y = true;

        FileReading x = new FileReading(); //Create a new FileReading object
        matrix = x.read(); //Call read method for reading the numbers

        for (int i = 0; i < 9; i++) {
            Arrays.fill(array, 0); //Initialising the Characteristic Vector with 0.
            for (int j = 0; j < 9; j++) {
                //Checks if numbers are between 1 and 9, a necessarily condition to have a possible correct sudoku
                if (matrix[i][j] > 0 && matrix[i][j] < 10 && matrix[j][i] > 0 && matrix[j][i] < 10) {
                    //Update the characteristic vector for each number
                    array[matrix[i][j]]++;
                    array[matrix[j][i]]++;
                }else {
                    //If it is impossible to have a correct sudoku return false and stop
                    y = false;
                    return y;
                }
            }
            for (int k = 1; k < array.length; k++) {
                //If a number appears more than once on a line or on a column return false and stop
                if (array[k] != 2) {
                    y = false;
                    return y;
                }
            }
        }
        return y;
    }
}
