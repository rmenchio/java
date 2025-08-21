package org.example.P1504;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (mat[i][j] == 0) ? 0 : heights[j] + 1;
            }
            ans += expandirHistograma(heights);
        }

        return ans;
    }

    private int expandirHistograma(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int sum = 0;
        int rowTotal = 0;

        for (int j = 0; j < heights.length; j++) {
            int h = heights[j];

            if (h == 0) {
                stack.clear();
                sum = 0;
                continue;
            }

            int width = 1;

            while (!stack.isEmpty() && stack.peek()[0] >= h) {
                int[] top = stack.pop();
                sum -= top[0] * top[1];
                width += top[1];
            }

            stack.push(new int[]{h, width});

            sum += h * width;
            rowTotal += sum;
        }
        return rowTotal;
    }
}
