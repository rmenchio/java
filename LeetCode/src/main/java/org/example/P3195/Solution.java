package org.example.P3195;

public class Solution {
    public int minimumArea(int[][] grid) {
        var linhas = grid.length;
        var colunas = grid[0].length;

        var eixoXsuperior = 0;
        var eixoXinferior = 0;

        var eixoYsuperior = 0;
        var eixoYinferior = 0;


        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++)
            {
                var atual = grid[i][j];

                if(atual == 1)
                {
                    eixoXsuperior = i;
                    i = linhas;
                    break;
                }
            }
        }

        for(int i = linhas - 1; i > 0; i--){
            for(int j = 0; j < colunas; j++)
            {
                var atual = grid[i][j];

                if(atual == 1)
                {
                    eixoXinferior = i;
                    i = 0;
                    break;
                }
            }
        }

        for(int j = 0; j < colunas; j++)
        {
            for(int i = 0; i < linhas; i++) {
                var atual = grid[i][j];

                if (atual == 1) {
                    eixoYsuperior = j;
                    j = colunas;
                    break;
                }
            }
        }

        for(int j = colunas - 1; j > 0; j--)
        {
            for(int i = 0; i < linhas; i++) {
                var atual = grid[i][j];

                if (atual == 1) {
                    eixoYinferior = j;
                    j = 0;
                    break;
                }
            }
        }

        return ((eixoXinferior - eixoXsuperior) + 1) * ((eixoYinferior - eixoYsuperior) + 1);
    }
}