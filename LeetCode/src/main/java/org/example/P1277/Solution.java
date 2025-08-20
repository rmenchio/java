package org.example.P1277;

public class Solution {
    public int countSquares(int[][] matrix) {
        var linhas = matrix.length - 1;
        var colunas = matrix[0].length - 1;
        var total = 0;

        for(int i = 0; i <= linhas; i++)
        {
            for(int j = 0; j <= colunas; j++){
                var atual = matrix[i][j];

                if(atual == 1)
                {
                    total += expandir(matrix, i, j, linhas, colunas, 1, total);
                }
            }
        }

        return total;
    }

    private int expandir(int[][] matrix, int i, int j, int linhas, int colunas, int tamanho, int somaElementos) {
        if(tamanho == 1 && matrix[i][j] == 1)
            return 1 + expandir(matrix, i, j, linhas, colunas, tamanho + 1, 0);

        somaElementos++;
        var linhaDiagonal = i + (tamanho - 1);
        var colunaDiagonal = j + (tamanho - 1);

        if(linhaDiagonal > linhas || colunaDiagonal > colunas)
            return 0;

        if(matrix[linhaDiagonal][colunaDiagonal] == 1){
            somaElementos++;

            for(int x = j; x < colunaDiagonal; x++){
                if(matrix[linhaDiagonal][x] == 1)
                    somaElementos++;
            }

            for(int y = i; y < linhaDiagonal; y++){
                if(matrix[y][colunaDiagonal] == 1)
                    somaElementos++;
            }
        }

        if(somaElementos == (tamanho * tamanho))
            return 1 + expandir(matrix, i, j, linhas, colunas, tamanho + 1, somaElementos - 1);
        else
            return 0;
    }
}