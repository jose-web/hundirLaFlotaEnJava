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

    public void mostrar() {
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
                System.out.print(VALORES[this.tableroVisual[i][j]] + "\t");
            }
            System.out.println();
        }
    }

}
