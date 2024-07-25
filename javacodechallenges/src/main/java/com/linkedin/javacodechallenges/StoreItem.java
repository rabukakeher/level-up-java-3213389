package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreItem {
  String name;
  double retailPrice;
  double discount;

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {
    // TODO: Implement
    if(items.isEmpty()) return Optional.empty();
    
    StoreItem leastExpensiveItem = null;
    double minVal = Double.MAX_VALUE; //leastExpensiveItem.getRetailPrice() - (leastExpensiveItem.getRetailPrice() * leastExpensiveItem.getDiscount());
    for(StoreItem item : items) {
      double val = item.getRetailPrice() - (item.getRetailPrice() * item.getDiscount());
      if(val < minVal) {
        minVal = val;
        leastExpensiveItem = item;
      }
    }

    return Optional.of(leastExpensiveItem);
  }

  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }
}