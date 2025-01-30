package io.github.ivan100kg;

import io.github.ivan100kg.task.LongestPalindromic;
import io.github.ivan100kg.task.ReverseNumber;
import io.github.ivan100kg.task.yandex.ChipWay;
import io.github.ivan100kg.task.yandex.ExpensiveWay;
import io.github.ivan100kg.task.yandex.Task;

public class Main {
    public static void main(String[] args) throws Exception {
        Task task = new ExpensiveWay();
        task.run();
    }
}