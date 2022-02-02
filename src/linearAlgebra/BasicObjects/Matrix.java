package linearAlgebra.BasicObjects;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/* this object contains Matrix and gives opportunities to configure and also do basic operations with single matrix.
If you want to multiply two matrices you should use LinearOperations NOTA BENE PROBABLY SHOULD BE CHANGED
 */
public class Matrix implements LinearObject{
    final private int numberOfLines;
    final private int numberOfColumns;
    private Double[][] matrix;

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setMatrix() {
        setMatrix(System.in);
    }

    public void setMatrix(InputStream inputStreamSource) {
        Scanner sc = new Scanner(inputStreamSource);
        sc.useDelimiter(Pattern.compile("[ \n]"));
        this.matrix = new Double[numberOfLines][numberOfColumns];

        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
    }

    public Double[][] getMatrix() {
        return matrix;
    }

    public Matrix(int numberOfLines, int numberOfColumns) {
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
    }

    public void setElement(int line, int column, Object element) {
        try {
            matrix[line - 1][column - 1] = (Double) element;
        } catch (ClassCastException e) {
            System.out.println("Wrong input type, input should be numeric");
        }
    }

    public void printMatrix() {
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
