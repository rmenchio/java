package org.example.P904;

import java.util.*;

public class Solution {
    public int totalFruit(int[] fruits) {
        var melhorTamanho = 0;
        var lista = new HashSet<>();
        var indiceSegundo = 0;

        if(Arrays.stream(fruits).distinct().count() == 1 || Arrays.stream(fruits).distinct().count() == 2)
            return fruits.length;

        for (int i = 0; i < fruits.length; i++) {
            var tamanho = 0;

            for (int j = i; j < fruits.length; j++) {
                var atual = fruits[j];

                if(lista.stream().distinct().toList().size() == 1 && !lista.contains(atual))
                    indiceSegundo = j;

                lista.add(atual);
                tamanho++;

                if (lista.stream().distinct().toList().size() > 2)
                {

                    if (tamanho - 1 > melhorTamanho)
                        melhorTamanho = tamanho - 1;

                    i = indiceSegundo - 1;
                    lista.clear();
                    break;
                }else{
                    if (tamanho  > melhorTamanho)
                        melhorTamanho = tamanho;
                }
            }
        }

        return melhorTamanho;
    }
}