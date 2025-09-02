package org.example.P3025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int numberOfPairs(int[][] points) {
        var linha = points.length;
        var contador = 0;

        Arrays.sort(points, (a, b) -> {
            int comparacaoX = Integer.compare(b[0], a[0]);

            if (comparacaoX != 0) {
                return comparacaoX;
            }

            return Integer.compare(a[1], b[1]);
        });

        for(int i = 0; i < linha; i++)
        {
            var p1 = points[i];
            var px1 = p1[0];
            var py1 = p1[1];

            List<int[]> memoria = new ArrayList<>();

            for(int j = i + 1; j < linha; j++){
                var p2 = points[j];
                var px2 = p2[0];
                var py2 = p2[1];

                var check = -1;
                var jaExiste = false;

                if(px1 == px2 && py1 < py2)
                {
                    jaExiste = verificarEixoY(memoria, px2, py2);
                    check = 1;
                }
                else if(py1 == py2 && px1 > px2)
                {
                    jaExiste = verificarEixoX(memoria, px2, py2);
                    check = 1;
                }
                else if (px1 > px2 && py1 < py2)
                {
                    jaExiste = verificar(memoria, px2, py2);
                    check = 1;
                }

                if(!jaExiste && check == 1)
                {
                    memoria.add(new int[]{px2, py2});
                    contador++;
                }
            }

        }

        return contador;
    }

    private boolean verificarEixoY(List<int[]> memoria, int x, int y) {
        var achou = false;

        for(var item : memoria){
            if(item[1] < y && item[0] == x) {
                achou = true;
                break;
            }
        }

        return achou;
    }

    private boolean verificarEixoX(List<int[]> memoria, int x, int y) {
        var achou = false;

        for(var item : memoria){
            if(item[0] > x && item[1] == y) {
                achou = true;
                break;
            }
        }

        return achou;
    }

    private boolean verificar(List<int[]> memoria, int x, int y){
        var achou = false;

        for(var item : memoria){
            if(item[0] >= x && item[1] <= y) {
                achou = true;
                break;
            }
        }

        return achou;
    }
}