package org.example.P6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// PAYPALISHIRING
public class Solution {
    public String convert(String s, int numRows) {
        var stringChar = s.toCharArray();
        var dict = new HashMap<Integer, List<Character>>();

        for(int i = 0; i < numRows; i++){
            dict.put(i, new ArrayList<>());
        }

        if(numRows == 1)
            return s;

        var linha = 0;
        var subindo = true;

        for(int i = 0;i < s.length(); i++){
            dict.get(linha).add(stringChar[i]);

            if(subindo){
                if(linha == numRows - 1)
                {
                    subindo = false;
                    linha--;
                }else {
                    linha++;
                }
            }else {
                if(linha == 0)
                {
                    subindo = true;
                    linha++;
                }else {
                    linha--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numRows; i++){
            for(var c : dict.get(i)){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

// P