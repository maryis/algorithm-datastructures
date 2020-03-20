package main.java.algorithms;

import java.util.Arrays;

public class NQueenBackTracking {

    static int len;
    public static void main(String[] args) {
        //set data
        len=4;
        int[][] board = new int[len][len];
        for (int i = 0; i < len; i++)
            Arrays.fill(board[i], 0);

        //print board
        printSolution(board);

        nqbt(board,0);

        printSolution(board);
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < len; i++) { //i th item
            for (int j = 0; j < len; j++) {
                System.out.print(board[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static boolean nqbt(int[][] b, int col) {

        if (col == len) {
            return true;
        }

        for (int i = 0; i < len; i++) {

            if (isSafe(b, i, col)) {
                b[i][col] = 1;
                if (nqbt(b, col + 1))//check one step further, if its false, we return correct step to check other path
                    return true;
                b[i][col] = 0;

            }

        }
        return false;

    }

    private static boolean isSafe(int[][] b, int i, int j) {
        int k, h;
        for (k = 0; k < j; k++)//previous columns
            if (b[i][k] == 1)
                return false;

        for (k = 0; k < i; k++)//previous rows
            if (b[k][j] == 1)
                return false;

        for (k = j, h = i; k < len && h >=0; k++, h--) //right up diagonal
            if (b[h][k] == 1)
                return false;

        for (k = j, h = i; k >= 0 && h >= 0; k--, h--)//left up diagonal
            if (b[h][k] == 1)
                return false;
        return true;
    }

}
