package org.example.P2348;

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int tamanho = nums.length;
        long qnt = 0;
        long sequencia = 0;

        for(int i = 0; i < tamanho; i++){
            if(nums[i] == 0)
            {
                sequencia++;
                qnt += sequencia;
            }
            else{
                sequencia = 0;
            }
        }

        return qnt;
    }
}