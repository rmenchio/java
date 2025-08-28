package org.example.P3459;

public class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        var maiorEncontrado = 0;


        var linha = grid.length;
        var coluna = grid[0].length;

        for(int x = 0; x < linha; x++)
        {
            for(int y = 0; y < coluna; y++){
                var atual = grid[x][y];

                if(atual != 1)
                    continue;

                var tamanhoAtual = 1;

                int expandirParaEsquerdaSuperior = expandir(grid, x, y, -1, -1,  false, atual, tamanhoAtual);
                int expandirParaDireitaSuperior = expandir(grid, x, y, -1, +1,  false, atual, tamanhoAtual);
                int expandirParaEsquerdaInferior = expandir(grid, x, y, +1, -1,  false, atual, tamanhoAtual);
                int expandirParaDireitaInferior = expandir(grid, x, y, +1, +1,  false, atual, tamanhoAtual);

                tamanhoAtual = Math.max(Math.max(Math.max(expandirParaEsquerdaInferior, expandirParaDireitaInferior), expandirParaDireitaSuperior), expandirParaEsquerdaSuperior);

                maiorEncontrado = Math.max(tamanhoAtual, maiorEncontrado);
            }
        }

        return maiorEncontrado;
    }

    private int expandir(int[][] grid, int x, int y, int passoX, int passoY, boolean jaRotacionou, int ultimo, int tamanhoEncontrado) {
        var linha = grid.length;
        var coluna = grid[0].length;

        while(x + passoX >= 0 && y + passoY >= 0 && x + passoX < linha && y + passoY < coluna)
        {
            x += passoX;
            y += passoY;
            var atual = grid[x][y];

            if(((ultimo == 0 || ultimo == 1) && atual == 2) || (ultimo == 2 && atual == 0))
            {
                tamanhoEncontrado++;

                if(passoX == -1 && passoY == -1)
                {
                    int expandirParaEsquerdaInferior = expandir(grid, x, y, -1, -1,  jaRotacionou, atual, tamanhoEncontrado);
                    int expandirParaDireitaSuperior = 0;
                    int expandirParaEsquerdaSuperior = 0;

                    if(!jaRotacionou)
                    {
                        expandirParaDireitaSuperior = expandir(grid, x, y, -1, +1,  true, atual, tamanhoEncontrado);
                    }


                    tamanhoEncontrado = Math.max(Math.max(expandirParaDireitaSuperior, expandirParaEsquerdaInferior), expandirParaEsquerdaSuperior);

                    return tamanhoEncontrado;
                }

                else if(passoX == -1 && passoY == 1)
                {
                    int expandirParaDireitaSuperior = expandir(grid, x, y, -1, +1,  jaRotacionou, atual, tamanhoEncontrado);
                    int expandirParaEsquerdaSuperior = 0;
                    int expandirParaDireitaInferior = 0;

                    if(!jaRotacionou) {
                        expandirParaDireitaInferior = expandir(grid, x, y, +1, +1, true, atual, tamanhoEncontrado);
                    }

                    tamanhoEncontrado = Math.max(Math.max(expandirParaEsquerdaSuperior, expandirParaDireitaInferior), expandirParaDireitaSuperior);

                    return tamanhoEncontrado;
                }

                else if(passoX == 1 && passoY == -1)
                {
                    int expandirParaEsquerdaInferior = expandir(grid, x, y, +1, -1,  jaRotacionou, atual, tamanhoEncontrado);

                    int expandirParaEsquerdaSuperior = 0;
                    int expandirParaDireitaInferior = 0;

                    if(!jaRotacionou){
                        expandirParaEsquerdaSuperior = expandir(grid, x, y, -1, -1,  true, atual, tamanhoEncontrado);
                    }

                    tamanhoEncontrado = Math.max(Math.max(expandirParaEsquerdaSuperior, expandirParaDireitaInferior), expandirParaEsquerdaInferior);

                    return tamanhoEncontrado;
                }

                else if(passoX == 1 && passoY == 1)
                {
                    int expandirParaDireitaInferior = expandir(grid, x, y, +1, +1,  jaRotacionou, atual, tamanhoEncontrado);
                    int expandirParaDireitaSuperior = 0;
                    int expandirParaEsquerdaInferior = 0;

                    if(!jaRotacionou){
                        expandirParaEsquerdaInferior = expandir(grid, x, y, +1, -1,  true, atual, tamanhoEncontrado);
                    }

                    tamanhoEncontrado = Math.max(Math.max(expandirParaDireitaSuperior, expandirParaEsquerdaInferior), expandirParaDireitaInferior);

                    return tamanhoEncontrado;
                }

            }
            else {
                return tamanhoEncontrado;
            }
        }

        return tamanhoEncontrado;
    }
}