package linearAlgebra.BasicObjects;

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

    public Double getDeterminant(Double[][] matrixElements) {
        Double result = 0.0;
        if (matrixElements.length != 1){
            for (int i = 0; i < getNumberOfLines(); i++) {
                result += Math.pow(-1, i+2) * getDeterminant(getSlice(1,i+1,matrixElements));
            }
        }else{
            return matrixElements[0][0];
        }
        return result;
    }
}
