/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.swing.JOptionPane;
import productos.*;
import tiendavideojuegos.TiendaVideojuegos;

/**
 *
 * @author Josemolamazo
 */
public class ListasVideojuegos {

    PrintWriter escribir = null;
    FileWriter fich;

    public void crearListaVideojuegos(String nomeFicheiro, ArrayList<Videojuegos> listaVJ) {
        try {
            fich = new FileWriter(nomeFicheiro);
            escribir = new PrintWriter(fich);
            listaVJ.add(new Videojuegos("Final Fantasy VII", 29.90f, "vg1", "Square Enix", "PS4", 12, "Fantasia"));
            listaVJ.add(new Videojuegos("God of War", 63.50f, "vg2", "SantaMonica Studios", "PS4", 18, "Accion"));
            listaVJ.add(new Videojuegos("Primal", 9.99f, "vg3", "SCE Studio Cambridge", "PS2", 16, "Aventura"));
            listaVJ.add(new Videojuegos("Zelda: Breath of the Wild", 50.90f, "vg4", "Nintendo", "Switch", 8, "Aventura"));
            listaVJ.add(new Videojuegos("NintenDogs", 8.90f, "vg5", "Nintendo", "DS", 3, "Simulacion"));
            listaVJ.add(new Videojuegos("The Elder Scroll V: Skyrim", 35.50f, "vg6", "Bethesda Game Studios", "PC", 16, "Aventura"));
            listaVJ.add(new Videojuegos("Spyro Reignited Trilogy", 59.90f, "vg7", "Toys for Bob", "PS4", 8, "Fantasia"));
            listaVJ.add(new Videojuegos("Bayonetta", 45.50f, "vg8", "PlatinumGames", "PS3", 18, "Accion"));
            listaVJ.add(new Videojuegos("Bayonetta", 45.50f, "vg9", "PlatinumGames", "Switch", 18, "Accion"));
            listaVJ.add(new Videojuegos("Bayonetta 2", 55.50f, "vg10", "PlatinumGames", "Switch", 18, "Accion"));
            listaVJ.add(new Videojuegos("Outlast", 19.90f, "vg11", "Red Barrels", "PC", 18, "Terror"));

            for (Videojuegos vj : listaVJ) {
                escribir.println(vj.toString());
            }

        } catch (IOException ex) {
            System.out.println("No exista el fichero " + ex.toString());
        } finally {
            escribir.close();
        }

    }


    public void verListaVideojuegos(ArrayList<Videojuegos> listaVJ) {
        Iterator it = listaVJ.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public void ordenarVJ(ArrayList<Videojuegos> listaVJ) {
        TiendaVideojuegos obx = new TiendaVideojuegos();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ordenar por: "
                    + "\n 1. Genero"
                    + "\n 2. Precio creciente"
                    + "\n 3. Precio decreciente"
                    + "\n 4. Nombre desde la A"
                    + "\n 5. Nombre desde la Z"
                    + "\n 6. Salir"));
            switch (opcion) {
                case 1:
                    Collections.sort(listaVJ, new Comparator<Videojuegos>() {
                        @Override
                        public int compare(Videojuegos vj1, Videojuegos vj2) {
                            return new String(vj1.getGenero()).compareTo(new String(vj2.getGenero()));
                        }
                    });
                    verListaVideojuegos(listaVJ);
                    break;
                case 2:
                    Collections.sort(listaVJ, new Comparator<Videojuegos>() {
                        @Override
                        public int compare(Videojuegos vj1, Videojuegos vj2) {
                            return new Float(vj1.getPrecio()).compareTo(new Float(vj2.getPrecio()));
                        }
                    });
                    verListaVideojuegos(listaVJ);
                    break;

                case 3:
                    Collections.sort(listaVJ, new Comparator<Videojuegos>() {
                        @Override
                        public int compare(Videojuegos vj2, Videojuegos vj1) {
                            return new Float(vj1.getPrecio()).compareTo(new Float(vj2.getPrecio()));
                        }
                    });
                    verListaVideojuegos(listaVJ);
                    break;
                case 4:
                    Collections.sort(listaVJ);
                    verListaVideojuegos(listaVJ);
                    break;
                case 5:
                    Comparator<Videojuegos> comparador = Collections.reverseOrder();
                    Collections.sort(listaVJ, comparador);
                    verListaVideojuegos(listaVJ);
                    break;
                case 6:
                    obx.menu();

            }
        } while (opcion < 7);
    }

    public void salir() {
        System.exit(0);
    }
}
