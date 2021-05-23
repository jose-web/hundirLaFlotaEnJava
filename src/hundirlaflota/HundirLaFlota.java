/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.Scanner;

/**
 *
 * @author Jose
 */
public class HundirLaFlota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Tablero jugador = new Tablero(10);
        Tablero bot = new Tablero(10);

        String teclado;

        System.out.print("Introduce el número de barcos:");
        teclado = myObj.nextLine();
        System.out.println("");
        int numeroDeBarcos = Integer.valueOf(teclado);

        jugador.mostrarInterno();
        System.out.println("-----------------------------------------------");
        System.out.println("tipo: 1-5\tposicion: H o V");
        System.out.println("fila: 1-10\tcolumna: A-J");
        System.out.println("");
        System.out.println("Introduce los datos en este formato:'tipo posicion fila columna'");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < numeroDeBarcos; i++) {
            System.out.print("Introduce los barcos:");
            teclado = myObj.nextLine();
            System.out.println("");

            String[] arrayNuevoBarco = teclado.split(" ");

            int tipo = Integer.valueOf(arrayNuevoBarco[0]);

            boolean posicion = "H".equals(arrayNuevoBarco[1]);
            int fila = Integer.valueOf(arrayNuevoBarco[2]);
            int columna = Integer.valueOf(arrayNuevoBarco[3]);

            boolean comprueba = jugador.addBarco(tipo, posicion, fila, columna);

            if (comprueba) {
                numeroDeBarcos--;
                jugador.mostrarInterno();
            }

            /*
            jugador.addBarco(5, false, 1, 1);
            jugador.disparo(1, 1);
            jugador.disparo(1, 2);
            jugador.disparo(1, 2);
            Tablero.mostrarTableros(jugador, bot);
             */
        }

    }

}
