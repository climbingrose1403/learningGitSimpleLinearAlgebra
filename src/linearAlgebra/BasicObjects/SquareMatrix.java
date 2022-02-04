package linearAlgebra.BasicObjects;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class SquareMatrix extends Matrix {

    /*public SquareMatrix(int numberOfLines, int numberOfColumns) {
        if (numberOfLines == numberOfColumns) {
            //SquareMatrix(numberOfLines);
        } else {
            throw new WrongMatrixSizeException();
        }
    }
*/
    public SquareMatrix(int sizeOfMatrix) {
        super(sizeOfMatrix, sizeOfMatrix);
    }

    public Double getDeterminant(Double[] @NotNull [] matrixElements) {
        Double result = 0.0;
        if (matrixElements.length != 1){
            for (int i = 0; i < matrixElements.length; i++) {
                result += Math.pow(-1, i+2) * matrixElements[0][i] * getDeterminant(getSlice(1,i+1,matrixElements));
            }
        }else{
            return matrixElements[0][0];
        }
        return result;
    }
}
