package org.example.P2044;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        var bitwise = nums[0];

        var max = 0;
        var tam = nums.length;

        for(int i = 0; i < tam - 1; i++){
            bitwise = bitwise | nums[i+1];
        }

        System.out.println(bitwise);

        if(nums[0] == bitwise)
            max++;

        for (int num : nums) {
            var bit = num;

            for (int k = 1; k < tam; k++) {
                bit = bit | nums[k];

                if (bit == bitwise)
                    max++;
            }
        }

        return max;
    }
}
