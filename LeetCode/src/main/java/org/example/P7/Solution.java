package org.example.P7;

public class Solution {
    public int reverse(int x) {
        String numero = Integer.toString(x);
        boolean hasSignal = false;

        if(numero.contains("-"))
        {
            hasSignal = true;
            numero = numero.replace("-", "");
        }

        var numeroChar = numero.toCharArray();
        char[] charNumero;

        int j = 0;

        if(hasSignal)
        {
            charNumero = new char[numero.length() + 1];
            charNumero[j] = '-';
            j++;
        }else {
            charNumero = new char[numero.length()];
        }

        for(int i = numero.length() - 1; i >= 0; i--)
        {
            charNumero[j] = numeroChar[i];
            j++;
        }

        var joinNumero = new String(charNumero);

        long nLong = Long.parseLong(joinNumero);

        if(nLong < -2147483648 || nLong > 2147483647)
            return 0;

        return (int)nLong;
    }
}