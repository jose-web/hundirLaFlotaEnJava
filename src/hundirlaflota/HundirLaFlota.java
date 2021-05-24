/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.ArrayList;
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
        Scanner escanea = new Scanner(System.in);
        Tablero jugador = new Tablero(10);
        Tablero bot = new Tablero(10);

        String teclado;

        System.out.print("Introduce el número de barcos: ");
        teclado = escanea.nextLine();
        System.out.println("");
        int numeroDeBarcos = Integer.valueOf(teclado);

        int numeroDeBarcosJugador = numeroDeBarcos;
        int numeroDeBarcosBot = numeroDeBarcos;
        ArrayList<Integer> arrayTipos = new ArrayList<>();

        jugador.mostrarInterno();
        System.out.println("-----------------------------------------------");
        System.out.println("tipo: 1-5\torientación: H o V");
        System.out.println("fila: 1-10\tcolumna: A-J");
        System.out.println("");
        System.out.println("Introduce los datos en este formato:'tipo orientación fila columna'");
        System.out.println("-----------------------------------------------");

        while (numeroDeBarcosJugador != 0) {
            System.out.print("Introduce los barcos:");
            teclado = escanea.nextLine();
            System.out.println("");

            String[] arrayNuevoBarco = teclado.split(" ");

            int tipo = Integer.valueOf(arrayNuevoBarco[0]);
            arrayTipos.add(tipo);

            boolean orientacion = "H".equals(arrayNuevoBarco[1]);
            int fila = Integer.valueOf(arrayNuevoBarco[2]);
            int columna = Integer.valueOf(arrayNuevoBarco[3]);

            boolean comprueba = jugador.addBarco(tipo, orientacion, fila, columna);

            if (comprueba) {
                numeroDeBarcosJugador--;
                jugador.mostrarInterno();
            }
        }

        int compruebaRepeticion = 0;

        while (numeroDeBarcosBot != 0) {
            int tipo = arrayTipos.get(numeroDeBarcosBot - 1);
            boolean orientacion = Boolean.getBoolean(String.valueOf(random(0, 1)));
            int fila = random(0, 9);
            int columna = random(0, 9);

            boolean comprueba = bot.addBarco(tipo, orientacion, fila, columna);

            if (comprueba) {
                numeroDeBarcosBot--;
            } else {
                compruebaRepeticion++;
                if (compruebaRepeticion == 0) {
                    bot = new Tablero(10);
                    compruebaRepeticion = 0;
                    numeroDeBarcosBot = numeroDeBarcos;
                }
            }
        }

        System.out.println("-------------------");

        bot.mostrarInterno();

    }

    public static int random(int min, int max) {
        return Math.round(min + Math.round(Math.random() * max));
    }

}
