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
    private int disparos = 0;

    /*
        0 - vacio - .
        1 - Agua - ~
        2 - tocado - X
     */
    public Tablero(int tamanio) {
        this.tableroVisual = new int[tamanio][tamanio];
        this.tableroInterno = new int[tamanio][tamanio];
    }

    public boolean addBarco(int tamanio, boolean orientacion, int fila, int columna) {
        /*
            orientación 
                true - Horizontal
                false - Vertical
         */

        if (tamanio > tableroVisual.length || tamanio < 1
                || fila > tableroVisual.length - 1 || fila < 0
                || columna > tableroVisual.length - 1 || columna < 0
                || (orientacion && ((columna + tamanio) > tableroVisual.length))
                || (!orientacion && ((fila + tamanio) > tableroVisual.length))) {
            System.out.println("No se puede poner el barco");
        } else {
            for (int i = 0; i < tamanio; i++) {
                if (this.tableroInterno[orientacion ? fila : fila + i][orientacion ? columna + i : columna] != 0) {
                    System.out.println("No se puede poner el barco");
                    return false;
                }
            }
            for (int i = 0; i < tamanio; i++) {
                this.tableroInterno[orientacion ? fila : fila + i][orientacion ? columna + i : columna] = tamanio;
            }
            System.out.println("Barco introducido correctamente");
            return true;
        }
        return false;
    }

    public void disparo(int fila, int columna) {
        this.disparos++;
        if (this.tableroInterno[fila][columna] > 0) { // Tocado
            this.tableroInterno[fila][columna] = -this.tableroInterno[fila][columna];
            this.tableroVisual[fila][columna] = 2;
        } else if (this.tableroInterno[fila][columna] == 0) {
            // Agua
            this.tableroVisual[fila][columna] = 1;
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
        }
        System.out.println();
    }

    public void mostrar() {
        mostrar(false);
    }

    public void mostrarInterno() {
        mostrar(true);
    }

    public static void mostrarTableros(Tablero tablero1, Tablero tablero2) {
        System.out.println("");
        System.out.print("\t");
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                System.out.print("|\t\t");
            }
            for (int j = 0; j < tablero1.tableroVisual.length; j++) {
                System.out.printf("[%s]\t", LETRAS[j]);
            }
        }
        System.out.println("");

        for (int i = 0; i < tablero1.tableroVisual.length; i++) {

            for (int j = 0; j < tablero1.tableroVisual.length * 2; j++) {
                if (j == 0) {
                    System.out.printf("[%s]\t", i + 1);
                }
                if (j < tablero1.tableroVisual.length) {
                    System.out.print(VALORES[tablero1.tableroVisual[i][j]] + "\t");
                } else {
                    System.out.print(VALORES[tablero2.tableroVisual[i][j - tablero1.tableroVisual.length]] + "\t");
                }

                if (j == tablero1.tableroVisual.length - 1) {
                    System.out.printf("|\t[%s]\t", i + 1);
                }

            }
            System.out.println("");

        }

    }
}
