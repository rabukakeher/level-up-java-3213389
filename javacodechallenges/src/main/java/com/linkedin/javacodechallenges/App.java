package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Optional;

public class App {
    public static double calculateAverageChangeInvested(List<Double> purchases) {
        int numberOfPurchases = purchases.size();
        Optional<Double> totalInvested = purchases.stream()
         .map(value -> 1 - (value - value.longValue()))
         .reduce((value1, value2) -> value1 + value2);

         return totalInvested.isPresent() ? (totalInvested.get()/numberOfPurchases) : 0;
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
