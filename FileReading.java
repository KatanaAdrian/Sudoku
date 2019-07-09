import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
This class contains a method which reads numbers for sudoku from a file and returns a matrix with these elements
 */
public class FileReading {
    public int[][] read() {

        int auxMatrix[][] = new int[9][9];

        //Open the file with the numbers
        File elements = new File("G:\\Java\\Projects\\Sudoku\\src\\matElm.txt");
        try {
            Scanner numbers = new Scanner(elements);

            //Check if I have 81 numbers in the file, which are needed for a complete sudoku
            if (Integer.parseInt(numbers.nextLine()) == 81) { //If the sudoku is complete read the numbers and put them in a matrix
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        auxMatrix[i][j] = Integer.parseInt(numbers.nextLine());
                    }
                }
            } else { //If the sudoku is not complete display a message and stop the program
                System.out.println("Sudoku is not complete!");
                System.exit(1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return auxMatrix;
    }
}
