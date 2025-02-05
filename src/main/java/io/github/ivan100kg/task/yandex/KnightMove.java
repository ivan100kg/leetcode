package io.github.ivan100kg.task.yandex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KnightMove implements Task {
    @Override
    public void run() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] params = reader.readLine().split(" ");

        assert params.length == 2 && params[0].matches("^\\d+$") && params[1].matches("^\\d+$");

        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);

        int[][] matrix = new int[n][m];

        matrix[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j + 2 < m)
                    matrix[i+1][j+2] += matrix[i][j];
                if (i + 2 < n && j + 1 < m)
                    matrix[i+2][j+1] += matrix[i][j];
            }
        }


        writer.write(String.valueOf(matrix[n-1][m-1]));

        reader.close();
        writer.close();
    }

}
