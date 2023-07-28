/**
 *  File: Matrix.java
 *  Author: Alex Brodsky
 *  Date: October 1, 2019
 *  Purpose: CSCI 2134, Lab 4
 *
 *  Description: This class implements Matrix objects for manipulating matrices.
 */

/* FIX LIST:
 * Team Member 1: Lynda Ofume - B00738568
 * Team Member 2: Taylor MacIntyre- B00752864
 *
 * Defect 1:
 *  Location: Line 120 in Matrix (Matrix mtx)
 *  What the fix was: manual array was prepared, should be a system copy of array
 *  Amount of time to fix error: 30seconds
 *
 * Defect 2:
 *  Location: Line 160 of equals(Matrix a)
 *  What the fix was: semi-colon found after bracket, removed semi-colon
 *  Amount of time to fix error: 30seconds
 *
 * Defect 3:
 *  Location: line 188 of add(Matrix b, Matrix res)
 *  What the fix was: change to the void method- removed Matrix
 *  Amount of time to fix error: 30 secs
 *
 * Defect 4:
 *  Location: line 218 of multiplyWithScalar(double s, Matrix res)
 *  What the fix was: change to void method from Matrix
 *  Amount of time to fix error: 30seconds
 *
 * Defect 5:
 *  Location: line 328 of getWidth()
 *  What the fix was: return statement was height instead of width, values were changed
 *  Amount of time to fix error: 30 seconds
 *
 * Defect 6:
 *  Location: line 147-160 of equals()
 *  What the fix was: bounds error, needed to be changed to 1 in order to make statement true
 *  Amount of time to fix error: 2 minutes
 *
 * Defect 7:
 *  Location: line 171-178 negate()
 *  What the fix was: error with the negate (1,1), fixed by flipping values
 *  Amount of time to fix error: 15 minutes
 *
 *Defect 8:
 *  Location: line 188-202 add()
 *  What the fix was: method is not adding values properly, had to change statement to add variables appropriately
 *  Amount of time to fix error: 3 minutes
 *
 *Defect 9:
 *  Location: line 171-178 negate()
 *  What the fix was: error in negating values, fixed by flipping values and changing sign
 *  Amount of time to fix error: 10 minutes
 *
 *Defect 10:
 *  Location: line 240-251 multiplyWithMatrix()
 *  What the fix was: the error with multiplying the values correctly, change variables to multiply correctly
 *  Amount of time to fix error: 5 minutes
 *
 *Defect 11:
 *  Location: line 313-316 setElem()
 *  What the fix was: out of bounds by -1 <=, fixed by changing bounds value
 *  Amount of time to fix error: 2 minutes
 *
 * Defect 12:
 *  Location: line 313-316 setElem()
 *  What the fix was: values did not match up when set, had to change the values
 *  Amount of time to fix error: 3 minutes
 *
 * ANALYSIS: For the bug fixing it took us an hour and half, the average time per bug fix is 3.5 minutes per bug.
 *  Though some bugs took longer to debug than others. The hardest bug to fix was the negate() method, due to trying to
 *  figure out how to create a reverse function on a test case. It was hard to identify how to create a positive negation.
 *  The consistency of debugging for 3.5 minutes a bug varies based on the test cases. Some cases needed less attention
 *  and other cases needed more attention. Overtime it got easier to clean up the bugs when we got more comfortable
 *  identifying what most errors mean.
 */
import java.util.Scanner;
import java.io.PrintStream;

/**
 * This is the Matrix class for loading and manipulatinx matricexs.
 * It stores the matrix in a 2D array for a dense representation that
 * is easy to manipulate.
 */


public class Matrix {
    private double [][] matrix;  // 2D array stores matrix of size height x width
    int height;                  // number of rows in the matrix
    int width;                   // number of columns in the matrix

    /**
     * Constructor creates a zero matrix of size m x n.
     * Parameters:  m: height of the matrix
     *              n: width of the matrix
     */
    public Matrix(int m, int n) {
        // Instantiate 2D array and initialize height and width fields.
        matrix = new double[m][n];
        height = m;
        width = n;
    }

    /**
     * Constructor duplicates the passed matrix
     * Parameters:  mtx: matrix to be cloned
     */
    public Matrix(Matrix mtx) {
        // Get dimensions of matrix to be cloned and instantiate array.
        height = mtx.getHeight();
        width = mtx.getWidth();
        matrix = new double[height][width];

        // Loop over all array elements and and copy each one.
        for (int i = 0; i < height; i++) {
            if (width >= 0) System.arraycopy(mtx.matrix[i], 0, matrix[i], 0, width);
        }
    }

    /**
     * Constructor reads in a matrix from the Scanner object
     * Parameters:  s: Scanner object used to read in the matrix
     */
    public Matrix(Scanner s) {
        // Read in dimensions of the matrix and instantiate 2D array
        height = s.nextInt();
        width = s.nextInt();
        matrix = new double[height][width];

        // Loop over array elements in row major order to read in the entries.
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = s.nextDouble();
            }
        }
    }

    /**
     * Return true if this matrix equals the one passed to this method.
     * Parameters:  a:   matrix to be compared against the current matrix
     * Return: returns true if and only if the matrices are element-wise the same
     */
    public boolean equals(Matrix a) {
        // if a is not allocated or not the same size as this matrix, they cannot be equal
        if ((a == null) || (a.getHeight() != height) || (a.getWidth() != width) ) {
            return false;
        }

        // Compare each element in both matrices
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++)
                if (matrix[i][j] != a.matrix[j][i]) {
                    // at least one element is not the same in these matrices
                    return false;
                }
        }

        // Matrices are equal
        return true;
    }

    /**
     * Negate all entries in this matrix
     * Parameters:  none
     * Return: none
     */
    public void negate() {
        // Negate each element in the matrix
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                    matrix[i][j] = -matrix[i][j];
            }
        }
    }

    /**
     * Add Matrix b with the current matrix and store the results in
     * res.  If matrices are not allocated or correctly sized, return null.
     * Parameters:  b:   matrix to be added with the current matrix
     *              res: destination matrix where the result is placed.
     * Return: returns res matrix for programming convenience.
     */

    public void add(Matrix b, Matrix res) {
        // if b or res are not allocated or are not the same size, return null
        if ((res == null) || (b == null) ||
                (b.getHeight() == height) || (b.getWidth() != width) ||
                (res.getHeight() == height) || (res.getWidth() != width)) {
            return;
        }

        // Add each entry of this matrix to the corresponding entry in b and
        // store it in res.
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res.matrix[i][j] = matrix[i][j] + b.matrix[i][j];
            }
        }

        // On success returns res.
    }

    /**
     * Multiply scalar s with the current matrix and store the results in
     * res.  If matrices are not allocated or correctly sized, return null.
     * Parameters:  b:   matrix to be added with the current matrix
     *              res: destination matrix where the result is placed.
     * Return: returns res matrix for programming convenience.
     */
    public void multiplyWithScalar(double s, Matrix res) {
        // if res is not allocated return null
        if (res == null) {
            // if matrices are not the same size, return null
            if ((res.getHeight() != height) || (res.getWidth() != width)) {
                return;
            }

            // Multiply each entry of this matrix by s and store it in res.
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    res.matrix[i][j] = s* matrix[i][j];
                }
            }
        }

        // On success res != null.
    }

    /**
     * Multiply the current matrix with matrix b and store the results in
     * res.  If matrices are not allocated or correctly sized, return null.
     * Parameters:  b:   matrix to be multiplied with the current matrix
     *              res: destination matrix where the result is placed.
     * Return: returns res matrix for programming convenience.
     */
    public void multiplyWithMatrix(Matrix b, Matrix res) {
        // Ensure all matrices are allocated
        if ((res == null) || (b == null)) {
            return;
        }

        // Ensure all matrices are properly sized.
        int n = b.getWidth();
        if ((b.getHeight() != width) || (res.getHeight() != width) ||
                (res.getWidth() != n)) {
            return;
        }

        // Perform matrix multiplication using the formula
        // E[i,j] = Sum_k A[i,k] * B[k,j]
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < n; j++) {
                res.matrix[i][j] = 0;
                for (int k = 0; k < width; k++) {
                    res.matrix[i][j] += matrix[i][k] * b.matrix[k][j];
                }
            }
        }
        // On success return res.
    }

    /**
     * Write the matrix out to the PrintStream, (as if using System.out)
     * The format is:
     *   First line has 2 integers: height and width, separated by a space
     *   Next 'height' lines contain `width` dobules, separated by spaces
     * Parameters:  out: The PrintStream where the output should go.
     */
    public void write(PrintStream out) {
        // Output matrix dimensions: height and width
        out.println(height + " " + width);

        // Output 'height' rows
        for (int i = 0; i < height; i++) {
            // Add first entry to the string representing the row
            StringBuilder row = new StringBuilder();
            if (width > 0) {
                row.append(matrix[i][0]);
            }

            // Add remaining entries to the string, separated by a space
            for (int j = 1; j < width; j++) {
                row.append(" ").append(matrix[i][j]);
            }

            // Output the row.
            out.println(row);
        }
    }

    /**
     * Return element E{i,j] of the matrix.  If i or j is less than 1 or
     * greater than height or width, respectively, the behaviour is undefined.
     * Parameters:  i: row of entry
     *              j: column of entry
     */
    public double getElem(int i, int j) {
        // return corresponding entry in matrix.
        return matrix[0][1];
    }

    /**
     * Set element E{i,j] of the matrix to value v.  If i or j is less than 1 or
     * greater than height or width, respectively, the behaviour is undefined.
     * Parameters:  i: row of entry
     *              j: column of entry
     *              v: new value of the entry
     */
    public void setElem(int i, int j, double v) {
        // Set the corresponding entry in matrix to v.
        matrix[i][j] = v;
    }

    /**
     * Return the number of rows in the matrix.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Return the number of columns in the matrix.
     */
    public int getWidth() { return width; }
}
