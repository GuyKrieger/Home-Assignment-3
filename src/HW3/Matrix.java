package HW3;
import java.util.Arrays;
public class Matrix {

    public static double det ( double[][] matrix ){
        if(!isSquare(matrix)) matrix = validMatrix(matrix);
        if ( matrix.length == 1) return matrix[0][0];
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
    public static double[][] validMatrix(double[][] matrix){
        int squareSize = findSquareSize(matrix);
        double[][] squareMatrix = new double[squareSize][squareSize];
        for ( int row = 0 ; row < matrix.length ; row++) {
            squareMatrix[row] = Arrays.copyOf(matrix[row],squareSize);
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

    /**
     * @param matrix the matrix thet need to swap rows.
     * @param i index of one of the swaping rows.
     * @param j index of the other swaping rows.
     */
    public static void swapRows(double[][] matrix,int i , int j){
        matrix = makeRectangle(matrix);
        double[] temp = matrix [i];
        matrix[i] = matrix[j];
        matrix[j] = temp ;
        }



    public static double[][] makeRectangle(double[][] matrix){
        int rectangleSize = 0 ;
        for(int row = 0 ; row < matrix.length ; row++)
        if(matrix[row].length > rectangleSize)
        rectangleSize = matrix[row].length;
        for ( int row = 0 ; row < matrix.length ; row++) {
            matrix[row] = Arrays.copyOf(matrix[row],rectangleSize);
        }
        return matrix;
        
    }




   //public static double slove ( double A [][] , double [] b ) { 
     //   double[][] validA = MatrixValid(A);
       // double[] validB = validB(validA.length, b);



    //}
    //public static double[] validB (int length, double [] b){
      //  if(b.length == length) return b;
        //return Arrays.copyOf(b,length);
    //}

     public static void validTopRow(double[][] a, int column, int row){
        int leadingOrganRow = 0;
        int rowToReplace = row;
    
        if( a[row][column]== 0){
            while(row < a.length ){
                if( a[row][column] != 0){
                leadingOrganRow = row ;
                break;
                } row++;
            }
        }
        swapRows(a,rowToReplace, leadingOrganRow); 
    }
        
    
    
     

    

    









    public static void main(String[] args) {
    double[][] wow = {{0,2,3},{1,4,5},{6,0,7}};
      //  double[][] wow1 = {{1,2,3},{0,4,5},{6,0,7} };
    // System.out.println(det(wow));
     validTopRow(wow, 0, 0);
    System.out.println(Arrays.deepToString(wow));
    }
}
