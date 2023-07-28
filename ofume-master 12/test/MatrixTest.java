import java.lang.Object;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/* Test failure record:
 *    [Name of test method]  [Method that failed]   [Notes]
 * 1.    multiplyWithMatrix(Matrix b, Matrix res)- whitebox approach
 *          -the methods that failed were the "parameter" as the matrix is not set up in the right values.
 *          it is not given what boundaries to stay in within values and the arraylist is not
 *          functioning properly
 *          - properly creating an appropriate matrix in the Matrix.java in order to be tested with all numbers
 *
 * 2.    multiplyWithScalar(Matrix b, Matrix res)- whitebox approach
 *         - the methods that failed were the assumption that the values inputted should be an integer but were meant to be
 *              a double value. As well Junit does not execute the arraylist from the Matrix.java
 *          - allow for the inputted height and width to be double and not equal zero
 *
 * 3.   add(Matrix b, Matrix res)- whitebox approach
 *      - error saying there is no parameter though the parameter is shown to be created and added
 *      - issue with executing the main method
 *      - the bug could be cleaned up by going through the code and specifying the value inputted first as a double
 *
 * .
 *  ...
 */
class MatrixTest {


    @Test
    void testEquals() {
    }

    @Test
    void negate() {
    }

    /* This tests whether or not values can be inputted into the matrix
    * adding numbers to the matrix and then testing the false and equals
    * assertion- whitebox approach
    * the test assumes that the values produced and inserted are integers */
    @Test
    void add(Matrix b, Matrix res) {
        Matrix m= new Matrix(1,1);
        double [][] Matrix1= {{2,4},{5,6}};
        double [][] Matrix2 = {{10,14},{15,20}};
        Matrix iMatrix= new Matrix(b);
        Matrix fMatrix= new Matrix(res);
        assertEquals(1.0 ,iMatrix.getElem(1,2));
        m.add(null,null);
        assertFalse(m!=null);
    }



    /* This test tests out the the scalar method that will create the matrix for the
    *  if the values do not fit in the matrix a null value will be returned
    * The test will see if the matrix can be initialized, created, and print the height for the given matrice
    * and then see whether the height can be tested to see if their is no height i.e 0.- whitebox approach
    * the test assumes that the values produced and inserted are integers
    */
    @Test
    void multiplyWithScalar(double s, Matrix res) {
        int r = 0;
        int l=0;
        double [][] Matrix3= {{6,10},{14,17}};
        double [][] Matrix4= {{6,10},{14,17}};
        Matrix myTrix = new Matrix(r, l);
        assertTrue(Matrix3.equals(Matrix4));
        assertTrue(res.height==r);
        System.out.print(res.getHeight());
        System.out.print(res.getWidth());



    }

    /* This test to see whether the matrix is placed appropriately in res,
    this test allows you to see whether or not the user will be able to accurately
    use the matrix- whitebox approach
    - the test assumes that the values produced and inserted are integers
     */
    @Test
    void multiplyWithMatrix(Matrix b, Matrix res) {
        int r=0;
        Matrix m= new Matrix(1,1);
        double [][] Matrix1= {{2,4,9},{5,6,9},{2,5,6}};
        double [][] Matrix2 = {{10,12,14},{15,16,20}, {30,35,40}};
        double [][] oMatrix= {{41,23,45},{56,58,60},{71,73,75}};
        Matrix matrixH=  new Matrix(3,4);
        assertTrue(Matrix1.equals(Matrix2));
        assertTrue(res.equals(b));


    }

    @Test
    void getElem() {
    }

    @Test
    void setElem() {
    }

    @Test
    void getHeight() {
    }

    @Test
    void getWidth() {
    }
}