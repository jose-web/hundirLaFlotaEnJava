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
        Tablero tabla1 = new Tablero(10);
        tabla1.addBarco(5, false, 1, 1);
        tabla1.disparo(1, 1);
        tabla1.disparo(1, 2);
        Tablero tabla2 = new Tablero(10);
        tabla2.disparo(1, 2);
        Tablero.mostrarTableros(tabla1, tabla2);
    }

}
