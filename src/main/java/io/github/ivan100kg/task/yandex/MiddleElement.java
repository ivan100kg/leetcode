package io.github.ivan100kg.task.yandex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MiddleElement implements Task {

    @Override
    public void run() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        java.util.List<Integer> sortedList = java.util.Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted().toList();

        writer.write(sortedList.get(1).toString());
        reader.close();
        writer.close();
    }
}
