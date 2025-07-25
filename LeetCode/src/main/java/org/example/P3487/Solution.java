package org.example.P3487;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        Set<Integer> negativeNumsSet = new HashSet<>();

        for (int num : nums) {
            if (num > 0)
                numsSet.add(num);
            else
                negativeNumsSet.add(num);
        }

        if(numsSet.size() == 0)
            return negativeNumsSet.stream().max(Comparator.naturalOrder()).get();

        return numsSet.stream().mapToInt(e -> e).sum();
    }
}