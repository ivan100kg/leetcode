package io.github.ivan100kg.task.yandex;

import java.io.*;
import java.util.ArrayList;

public class ExpensiveWay implements Task {
    @Override
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] matrix = createMatrix(reader);
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] cacheMatrix = new int[n][m];
        String[][] directionMatrix = new String[n][m];

        // start point
        cacheMatrix[0][0] = matrix[0][0];
        directionMatrix[0][0] = "";

        // column
        for (int i = 1; i < n; i++) {
            cacheMatrix[i][0] = cacheMatrix[i - 1][0] + matrix[i][0];
            directionMatrix[i][0] = directionMatrix[i - 1][0] + "D ";
        }

        // row
        for (int i = 1; i < m; i++) {
            cacheMatrix[0][i] = cacheMatrix[0][i - 1] + matrix[0][i];
            directionMatrix[0][i] = directionMatrix[0][i - 1] = "R ";
        }

        // fill min sum
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                cacheMatrix[i][j] = matrix[i][j] + Math.max(cacheMatrix[i - 1][j], cacheMatrix[i][j - 1]);
                if (cacheMatrix[i - 1][j] > cacheMatrix[i][j - 1]) {
                    cacheMatrix[i][j] = matrix[i][j] + cacheMatrix[i - 1][j];
                    directionMatrix[i][j] = directionMatrix[i - 1][j] + "D ";
                } else {
                    cacheMatrix[i][j] = matrix[i][j] + cacheMatrix[i][j - 1];
                    directionMatrix[i][j] = directionMatrix[i][j - 1] + "R ";
                }
            }
        }

        writer.write(cacheMatrix[n-1][m-1] + "\n");
        writer.write(directionMatrix[n-1][m-1].trim());

        reader.close();
        writer.close();
    }

    private static int[][] createMatrix(BufferedReader reader) throws IOException {
        String[] matrixSize = reader.readLine().split(" ");

        assert matrixSize.length < 2 : "error";

        int n = Integer.parseInt(matrixSize[0]);
        int m = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for(int j = 0; j < m; j++)
                matrix[i][j] = Integer.parseInt(row[j]);
        }

        return matrix;
    }
}
