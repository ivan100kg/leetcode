package io.github.ivan100kg.task.yandex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Cafe implements Task {
    @Override
    public void run() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String param = reader.readLine();
        int[] costs = new int[Integer.parseInt(param)];

        for (int i = 0; i < costs.length; i++)
            costs[i] = Integer.parseInt(reader.readLine());

        int sum = 0;
        int coupon = 0;
        int usedCoupon = 0;
        StringBuilder days = new StringBuilder();

        for (int i = 0; i < costs.length; i++) {
            if (coupon > 0) {
                // найдём обеды меньше 100
                int[] couponDinners = new int[costs.length - i];
                for (int j = i, l = 0; j < costs.length; j++, l++) {
                    if (costs[j] < 100)
                        couponDinners[l] = costs[j];
                    else
                        couponDinners[l] = 0;
                }
                // найти максимальный cost < 100
                int maxCostDinner = 0;
                for (int k = 0; k < couponDinners.length; k++) {
                    if (couponDinners[k] > maxCostDinner)
                        maxCostDinner = couponDinners[k];
                }

                // тратим купон на самый дорогой обед
                if (maxCostDinner > 0) {

                    // индекс элемента с максимальной стоимостью
                    int maxCostDinnerIndex = 0;
                    for (int j = i; j < costs.length; j++) {
                        for (int k = 0; k < couponDinners.length; k++) {
                            if (couponDinners[k] == costs[j]) {
                                maxCostDinnerIndex = j;
                                break;
                            }
                        }
                    }

                    coupon--;
                    usedCoupon++;
                    costs[maxCostDinnerIndex] = 0;
                    days.append(maxCostDinnerIndex + 1).append(" ");
                }
            }

            sum += costs[i];
            if (costs[i] >= 100)
                coupon++;
        }

        writer.write(sum + "\n");
        writer.write(coupon + " " + usedCoupon + "\n");
        writer.write(days.substring(0, days.length() - 1));

        reader.close();
        writer.close();
    }
}
