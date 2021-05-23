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
public class HundirLaFlota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero tabla = new Tablero(10);
        tabla.mostrar();
        tabla.addBarco(5, false, 1, 1);
        tabla.mostrarInterno();
        tabla.disparo(1, 1);
        tabla.disparo(1, 2);
        tabla.mostrar();
        tabla.mostrarInterno();

    }

}
