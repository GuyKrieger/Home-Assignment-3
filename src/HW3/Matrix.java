package HW3;
import java.util.Arrays;
public class Matrix {

    public static double det ( double[][] matrix ){
        if ( matrix.length == 1) return matrix[0][0];
        if (matrix.length == 2) return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        double posNeg, det = 0;
        for(int i = 0 ; i < matrix.length;i++) {
            posNeg = 1 ;
            if (i % 2 != 0) posNeg = -1;
            det += posNeg * matrix[0][i] * det(minor(matrix, i));
        }
        return det;
    }


    public static double[][] minor (double [][] makeMinor,int column){
        int minorSize = makeMinor.length-1;
        double[][] newMinor = new double[minorSize][minorSize];
            for ( int i = 1 ; i < makeMinor.length ; i++) {
                int c = 0;
                for (int j = 0; j < makeMinor.length; j++) {
                    if (j != column)
                        newMinor[i-1][c++] = makeMinor[i][j];
                }
            }
            return newMinor;
        }





    /**
     * cheks if matrix is square.
     * @param matrix the matrix been checked.
     * @return true or false.
     */


    public static boolean isSquare(double[][] matrix) {
        for(int row = 0 ; row < matrix.length ; row++)
            if( matrix.length != matrix[row].length)
                return false;
        return true;
        }

    /**
     * finding the matrix size.
     * by searching for the longest row or column.
     * @param matrix the matrix been checked.
     * @return integer for square matrix size.
     */
    public static int findSquareSize( double[][] matrix ){
        int squareSize = matrix.length;
        for (int row = 0 ; row < matrix.length ; row++)
            if(matrix[row].length > squareSize)
                squareSize = matrix[row].length;
        return squareSize;

    }

    /**
     * receiving a  matrix and making checking if its square.
     * if not it is making a new square matrix with the same organs and Zero`s.
     * @param matrix a not square matrix.
     * @return new square matrix.
     */
    public static double[][] MatrixValid(double[][] matrix){
        if (isSquare(matrix))
            return matrix;
        int size = findSquareSize(matrix);
        double[][] squareMatrix = new double[size][size];
        for ( int row = 0 ; row < matrix.length ; row++) {
            squareMatrix[row] = Arrays.copyOfRange(matrix[row], 0, size);
        }
        return squareMatrix;

    }

    /**
     * this method checks if 2 matrix are equal using defoliate threshold.
     * @param a first matrix.
     * @param b second matrix.
     * @return return true/false.
     */

     public static boolean equlas (double[][] a, double[][] b) {
        if( a.length != b.length) return false;
        for( int row = 0 ; row < a.length ; row++)
            for(int column = 0 ; column < a.length ; column ++)
                if(! vectorAssignment.equals(a[row][column],b[row][column]))
                    return false;
        return true;
    }

    /**
     * this method checks if 2 matrix are equal with a given threshold.
     * @param a first matrix.
     * @param b second matric
     * @param treshold given double to compare with.
     * @return true/false.
     */

    public static boolean equlas (double[][] a, double[][] b,double treshold) {
        if( a.length != b.length) return false;
        for( int row = 0 ; row < a.length ; row++)
                if(! vectorAssignment.equals(treshold,a[row],b[row]))
                    return false;
        return true;
    }
    static double slove ( double A [][] , double [] b ) {
        double[][] newA = MatrixValid(A);


    }
    static double[] validB (int length, double [] b){
        if(b.length == length) return b;

    }









    public static void main(String[] args) {
    double[][] wow = {{1,2,3},{0,4,5},{6,0,7}};
        double[][] wow1 = {{1,2,3},{0,4,5},{6,0,7}};
    double det = det(MatrixValid(wow));
    double d = 0;
    System.out.println(equlas(wow1,wow1,d));
    }
}
