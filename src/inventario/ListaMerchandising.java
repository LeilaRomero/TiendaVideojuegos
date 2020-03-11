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
import productos.Merchandising;
import tiendavideojuegos.TiendaVideojuegos;

/**
 *
 * @author Leila
 */
public class ListaMerchandising {

    PrintWriter escribir = null;
    FileWriter fich;
   

    public void crearListaMerchandising(String nomeFicheiro, ArrayList<Merchandising> listaM) {
        try {
            fich = new FileWriter(nomeFicheiro, true);
            escribir = new PrintWriter(fich);
            listaM.add(new Merchandising("Spyro", "Figura", "Figura de Spyro The Dragon", 60.90f, "65SPY022", "First 4 Figures"));
            listaM.add(new Merchandising("The Eyes of Bayonetta 2", "Libro", "Tapa dura", 34.90f, "54LKJ52", "Eyes of Bayonetta"));
            listaM.add(new Merchandising("Star Wars", "Poster", "Tamaño 100x70cm", 15.50f, "54PIU25", "Disney"));
            listaM.add(new Merchandising("Sailoor Moon", "Pack", "Pack regalo taza, llavero y chapas Sailoor Moon", 19.99f, "SAI18111902", "Set De Chapas Siloor Moon"));
            listaM.add(new Merchandising("Marvel Camiseta", "Camiseta", "Camiseta unisex de Marvel", 19.90f, "MAR19121802-L", "Marvel"));
            listaM.add(new Merchandising("Vasos", "Casa", "Vasos de chupito", 14.90f, "ASS19121901", "Assassin's Creed"));
            listaM.add(new Merchandising("Hidromiel", "Comida", "Hidromiel Freyja Valhalla 33 cl", 4.90f, "OTR18041001", "Valhalla "));
            listaM.add(new Merchandising("Friends", "Juegos de mesa", "Trivial Friends", 23.90f, "FRI19122001", "Trivial Pursuit"));
            listaM.add(new Merchandising("Star Wars Deluxe Edition", "Poster", "Tamaño 91x61cm", 7.90f, "STA20012801", "Disney"));
            listaM.add(new Merchandising("Super Mario", "Figura", "Set de Figuras Articuladas Super Mario Nintendo 10 cm", 27.90f, "SUM19122722", "Nintendo"));
            for (Merchandising m : listaM) {
                escribir.println(m.toString());
            }
        } catch (IOException ex) {
            System.out.println("No existe el fichero " + ex.toString());
        } finally {
            escribir.close();
        }

    }

    public void verListaMerchandising(ArrayList<Merchandising> listaM) {
        Iterator it = listaM.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void ordenarMer(ArrayList<Merchandising> listaM) {
        TiendaVideojuegos obx = new TiendaVideojuegos();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ordenar por: "
                    + "\n 1. Precio creciente"
                    + "\n 2. Precio decreciente"
                    + "\n 3. Nombre desde la A"
                    + "\n 4. Nombre desde la Z"
                    + "\n 5. Salir"));
            switch (opcion) {
                case 1:
                    Collections.sort(listaM, new Comparator<Merchandising>() {
                        @Override
                        public int compare(Merchandising mer1, Merchandising mer2) {
                            return new Float(mer1.getPrecio()).compareTo(new Float(mer2.getPrecio()));
                        }
                    });
                    verListaMerchandising(listaM);
                    break;
                case 2:
                    Collections.sort(listaM, new Comparator<Merchandising>() {
                        @Override
                        public int compare(Merchandising mer1, Merchandising mer2) {
                            return new Float(mer2.getPrecio()).compareTo(new Float(mer1.getPrecio()));
                        }
                    });
                    verListaMerchandising(listaM);
                    break;
                case 3:
                    Collections.sort(listaM);
                    verListaMerchandising(listaM);
                    break;
                case 4:
                    Comparator<Merchandising> comparador = Collections.reverseOrder();
                    Collections.sort(listaM, comparador);
                    verListaMerchandising(listaM);
                    break;
                case 5:
                    obx.menu();

            }
        } while (opcion < 6);
    }

    public void salir() {
        System.exit(0);
    }
}
