package org.example.P1317;

public class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n - a;

        for(int i = 2; i < n; i++)
        {
            if(!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0"))
                break;

            a++;
            b--;
        }

        return new int[]{a, b};
    }
}

// 69
// 6 9
// 100 0
// 10 0
// 1 0
// 1 1