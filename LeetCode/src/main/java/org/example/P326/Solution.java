package org.example.P326;

class Solution {
    public boolean isPowerOfThree(int n) {
        int numero = n;
        int potencia = 1;

        if(numero == 1)
            return true;

        while (true){
            if(numero % 3 == 0 && numero != 0)
            {
                numero /= 3;
                potencia++;
            }
            else return numero == 1 && potencia > 1;
        }
    }
}