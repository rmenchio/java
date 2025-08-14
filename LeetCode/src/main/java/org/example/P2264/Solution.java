package org.example.P2264;

public class Solution {
    public String largestGoodInteger(String num) {
        var arrayNum = num.toCharArray();
        var maior = 0;
        var contador = 0;


        for (int i = 0; i < arrayNum.length - 2; i++) {
            int a = arrayNum[i] - '0';
            int b = arrayNum[i+1] - '0';
            int c = arrayNum[i+2] - '0';

            if (a == b && a == c)
            {
                contador++;

                if (a > maior)
                    maior = a;
            }

        }

        if(contador > 0)
            return Integer.toString(maior).repeat(3);
        else
            return "";
    }
}