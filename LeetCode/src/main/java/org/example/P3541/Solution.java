package org.example.P3541;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int maxFreqSum(String s) {
        var charArray = s.toCharArray();

        var dict = new HashMap<Character, Integer>();

        for(var c : charArray){
            if(dict.containsKey(c))
                dict.merge(c, 1, Integer::sum);
            else
                dict.put(c, 1);
        }

        LinkedHashMap<Character, Integer> dictOrdenado = dict.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue,
                    LinkedHashMap::new
            ));

        boolean achouVogal = false;
        boolean achouConsoante = false;
        var soma = 0;

        for(var set : dictOrdenado.entrySet())
        {
            if(!achouVogal && List.of('a','e','i','o','u').contains(set.getKey()))
            {
                achouVogal = true;
                soma += set.getValue();
            }
            else if(!achouConsoante && !List.of('a','e','i','o','u').contains(set.getKey())){
                achouConsoante = true;
                soma += set.getValue();
            }

            if(achouVogal && achouConsoante)
                return soma;
        }

        return soma;

    }
}