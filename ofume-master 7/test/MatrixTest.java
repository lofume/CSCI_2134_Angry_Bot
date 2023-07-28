/**
 *  File: MatrixTester.java
 *  Author: Alex Brodsky
 *  Date: October 1, 2019
 *  Purpose: CSCI 2134, Lab 4
 *
 *  Description: This class implements Matrix objects for manipulating matrices.
 */

/*  FIXLIST:
    NAME/BANNER DEVELOPER 1: LYNDA OFUME - B00738568
    NAME/BANNER DEVELOPER 2: TAYLOR MACINTYRE - B00752864

        Missing Test Cases based on specification requirements

    0. Passing bad indices to getElem() not tested.  getElem should generate an exception in this case.

    1.  Proper testing has failed to output proper exception in add(), the messages for testing state it is in the negate()
    method but should use add() in the message - testing issue (Time: 5 minutes)

    2. Passing bad indices to getElem_BadIndex() not tested, should use 1,0 to test the method, message should be created;
    issue was resolved by adding the message of the appropriate indices to pass- testing issue (Time: 2 minutes)

    3. Faulty testing in multiplyWithMatrix(), testing the multiplyWithScalar() in wrong section, the scalar testing is
    in the wrong section and should be tested in the multiplyWithScalar section - requirements issue (Time: 13 minutes)

    4. Lack of testing in multiplyWithMatrix(), there needs to be testing in regards to multiplication of the matrix-
        requirements issue (Time: ~11.5 minutes)

    5. Issue in getElem_BadIndex() testing, there should be an exception after the try statement, in case the
    wrong values are passed - testing/requirements issue (Time: 2 minutes)

    6.
    7.
    8.
    9.
    10.
    ... Add as many as necessary
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

class MatrixTest {
    private final static String simpleMatrix = "2 2 1 2 3 4"; // [ 1 2 ]
    // [ 3 4 ]
    private final static String nonSqMatrix = "3 2 1 2 3 4 5 6"; // [ 1 2 ]
    // [ 3 4 ]

    @Test
    void getElem() {
        Matrix m = new Matrix(new Scanner(simpleMatrix));
        assertEquals(2, m.getElem(1,2), "getElem() did not return correct value");
    }

    @Test
    // Example for item 0 in the FIX LIST above
    void getElem_BadIndex() {
        Matrix m = new Matrix(new Scanner(simpleMatrix));
        try {
            m.getElem(1, 0);
            assertFalse(true, "getElem() should have not throw an Exception");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), "i = 1, j = 0, height = 2, width = 2");
        }
    }

    @Test
    void setElem() {
        Matrix m = new Matrix(new Scanner(simpleMatrix));
        m.setElem(2, 1, 5);
        assertEquals(5, m.getElem(2,1), "setElem() may not have set correct value");
    }

    @Test
    void negate() {
        Matrix m = new Matrix(new Scanner(simpleMatrix));
        m.negate();
        assertEquals(-1, m.getElem(1,1), "negate() did not negate element (1,1)");
        assertEquals(-2, m.getElem(1,2), "negate() did not negate element (1,2)");
        assertEquals(-3, m.getElem(2,1), "negate() did not negate element (2,1)");
        assertEquals(-4, m.getElem(2,2), "negate() did not negate element (2,2)");
    }

    @Test
    void add() {
        try {
            Matrix m = new Matrix(new Scanner(simpleMatrix));
            Matrix n = new Matrix(new Scanner(simpleMatrix));
            Matrix res = new Matrix(2, 2);
            n.negate();
            m.add(n, res);
            assertEquals(0, res.getElem(1, 1), "add() did not add element (1,1))");
            assertEquals(0, res.getElem(1, 2), "add() did not add element (1,2)");
            assertEquals(0, res.getElem(2, 1), "add() did not add element (2,1)");
            assertEquals(0, res.getElem(2, 2), "add() did not add element (2,2)");
        } catch (Matrix.DimensionMismatchException e) {
            fail("Exception occurred where none should have " + e.getMessage());
        } catch (Matrix.NullMatrixException e) {
            fail("Exception occurred where none should have " + e.getMessage());
        }
    }

    @Test
    void equals() {
        Matrix m = new Matrix(new Scanner(simpleMatrix));
        Matrix n = new Matrix(m);
        assertTrue(m.equals(n), "equals() has a false negative");
    }

    @Test
    void equal2s() {
        Matrix m = new Matrix(new Scanner(simpleMatrix));
        Matrix n = new Matrix(m);
        n.negate();
        assertFalse(m.equals(n), "equals() has a false positive");
    }

    @Test
    void multiplyWithScalar() {
        try {
            Matrix m = new Matrix(new Scanner(simpleMatrix));
            Matrix n = new Matrix(m);
            Matrix res = new Matrix(m);
            n.negate();
            m.multiplyWithScalar(-1, res);
            assertTrue(res.equals(n), "matrix not scaled by -1");
        } catch (Matrix.DimensionMismatchException e) {
            fail("Exception occurred where none should have " + e.getMessage());
        } catch (Matrix.NullMatrixException e) {
            fail("Exception occurred where none should have " + e.getMessage());
        }
    }

    @Test
    void multiplyWithMatrix() {
        try {
            Matrix m = new Matrix(new Scanner(simpleMatrix));
            Matrix n = new Matrix(m);
            Matrix res = new Matrix(m);
            m.multiplyWithMatrix(n, res);
            assertEquals(7, res.getElem(1,1), "matrix multiplication failure on (1,1)");
            assertEquals(10, res.getElem(1,2), "matrix multiplication failure on (1,2)");
            assertEquals(15, res.getElem(2,1), "matrix multiplication failure on (2,1)");
            assertEquals(22, res.getElem(2,2), "matrix multiplication failure on (2,2)");

        } catch (Matrix.DimensionMismatchException e) {
            fail("Exception occurred where none should have " + e.getMessage());
        } catch (Matrix.NullMatrixException e) {
            fail("Exception occurred where none should have " + e.getMessage());
        }
    }

    @Test
    void getHeight() {
        Matrix m = new Matrix(new Scanner(nonSqMatrix));
        assertEquals(3, m.getHeight(), "getHeight() did not return correct height");
    }

    @Test
    void getWidth() {
        Matrix m = new Matrix(new Scanner(nonSqMatrix));
        assertEquals(2, m.getWidth(), "getWidth() did not return correct width");
    }
}
