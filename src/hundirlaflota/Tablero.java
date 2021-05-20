/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

/**
 *
 * @author Jose
 */
public class Tablero {

    private final int[][] tableroVisual;
    private final static char[] VALORES = {'.', '~', 'X'};
    private final static char[] LETRAS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final int[][] tableroInterno;

    /*
        0 - vacio - .
        1 - Agua - A
        2 - tocado - X
     */
    public Tablero(int tamanio) {
        this.tableroVisual = new int[tamanio][tamanio];
        this.tableroInterno = new int[tamanio][tamanio];
    }

    public void addBarco(int tamanio, boolean posicion, int fila, int columna) {
        /*
            posicion 
                true - Horizontal
                false - Vertical
         */

        if (tamanio > tableroVisual.length || tamanio < 1
                || fila > tableroVisual.length || fila < 1
                || columna > tableroVisual.length || columna < 1
                || (posicion && ((columna + tamanio) > tableroVisual.length))
                || (!posicion && ((fila + tamanio) > tableroVisual.length))) {
            System.out.println("No se puede poner el barco");
        } else {
            for (int i = 0; i < tamanio; i++) {
                this.tableroInterno[posicion ? fila : fila + i][posicion ? columna + i : columna] = tamanio;
            }
        }
    }

    private void mostrar(boolean interno) {
        System.out.println();
        for (int i = 0; i < this.tableroVisual.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < this.tableroVisual.length; j++) {
                if (i == 0) {
                    System.out.printf("[%s]\t", LETRAS[j]);
                }
            }
            System.out.println();
            for (int j = 0; j < this.tableroVisual.length; j++) {
                if (j == 0) {
                    System.out.printf("[%s]\t", i + 1);
                }
                String valor = interno
                        ? String.valueOf(this.tableroInterno[i][j])
                        : String.valueOf(VALORES[this.tableroVisual[i][j]]);

                System.out.print(valor + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void mostrar() {
        mostrar(false);
    }

    public void mostrarInterno() {
        mostrar(true);
    }

}
