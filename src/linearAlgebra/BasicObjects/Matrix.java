package linearAlgebra.BasicObjects;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/* this class contains basic operations that can be done with any kind of matrix
 */

public class Matrix implements LinearObject {
    final private int numberOfLines;
    final private int numberOfColumns;
    private Double[][] matrix;

    /** creates new matrix object with specified size
     * to set elements, use specified method
     * @param numberOfLines
     * @param numberOfColumns
     */
    public Matrix(int numberOfLines, int numberOfColumns) {
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
    }

    /** crates new matrix object from transferred Double[][]
     * matrix size matches array size
     *
     * @param matrix
     */
    public Matrix(Number[] @NotNull [] matrix) {
        numberOfLines = matrix.length;
        numberOfColumns = matrix[0].length;
        setMatrix(matrix);
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    /** this group of methods intended to set matrix elements
     * from different sources
      */
    public void setMatrix() {
        setMatrix(System.in);
    }

    public void setMatrix(Number[][] sourceArray) {
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                    matrix[i][j] = (Double) sourceArray[i][j];
            }
        }
    }

    public void setMatrix(InputStream inputStreamSource) {
        Scanner sc = new Scanner(inputStreamSource);
        sc.useDelimiter(Pattern.compile("[\s\n]*"));
        matrix = new Double[numberOfLines][numberOfColumns];

        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
    }


    public Double[][] getMatrix() {
        return matrix;
    }

    public void setElement(int line, int column, Number element) {
            matrix[line - 1][column - 1] = element.doubleValue();
    }

     /**returns a matrix without specified line and column
      if your matrix consist of 1 element returns null
      */
    public static Double[][] getSlice(int numberOfExcludingLine, int numberOfExcludingColumn, Double[] @NotNull [] matrixElements) {
        Double[][] slice = new Double[matrixElements.length - 1][matrixElements[0].length - 1];
        int tempLine = -1, tempColumn = -1;
        for (int i = 0; i < matrixElements.length; i++) {
            if (i != numberOfExcludingLine - 1) {
                tempLine++;
                for (int j = 0; j < matrixElements[0].length; j++) {
                    if (j != numberOfExcludingColumn - 1) {
                        tempColumn++;
                        slice[tempLine][tempColumn] = matrixElements[i][j];
                    }
                }
                tempColumn = -1;
            }
        }
        return slice.length == 0 ? null : slice;
    }

    /** returns matrix as string
     *
     * @return
     */
    public String getStringMatrix() {
        StringBuilder stringMatrix = new StringBuilder();
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                stringMatrix.append(matrix[i][j]);
                stringMatrix.append(" ");
            }
            stringMatrix.append("\n");
        }
        return stringMatrix.toString();
    }

    public void printMatrix() {
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void multiplyToNumber(Number number) {
        for(int i = 0; i < getNumberOfLines();i++){
            for(int j = 0 ; j < getNumberOfColumns();j++){
                matrix[i][j] *= number.doubleValue();
            }
        }
    }
}
