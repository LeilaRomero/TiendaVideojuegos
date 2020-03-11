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
import productos.ComponentesPC;
import tiendavideojuegos.TiendaVideojuegos;

/**
 *
 * @author Leila
 */
public class ListaComponentesPC {

    PrintWriter escribir = null;
    FileWriter fich;
   

    public void crearListaComponentesPC(String nomeFicheiro, ArrayList<ComponentesPC> listaCom) {
        try {
            fich = new FileWriter(nomeFicheiro, true);
            escribir = new PrintWriter(fich);
            listaCom.add(new ComponentesPC("Fuente de alimentacion", 39.99f, "4DS524", "Gaming", "Fuente de alimentacion", "650W de potencia"));
            listaCom.add(new ComponentesPC("Cascos", 30.99f, "8ODU245", "Energy System", "Cascos", "Inhalambricos perfectos para el ordenador"));
            listaCom.add(new ComponentesPC("Pack", 40.99f, "6DTS235", "Logiteck", "Teclado + raton", "Inhalambricos perfectos para el ordenador"));
            listaCom.add(new ComponentesPC("Pantalla", 50.99f, "6LJHU45", "LG", "Pantalla", "Pantalla de 23 pulgadas"));
            listaCom.add(new ComponentesPC("Tarjeta grafica", 127.99f, "2KDG215", "Endivia", "Grafica", "Gigabyte GeForce GTX 1050 OC 2GB GDDR5"));
            listaCom.add(new ComponentesPC("Procesador", 184.99f, "25LK458", "AMD", "Procesador", "AMD Ryzen 5 3600 3.6GHz BOX"));
            listaCom.add(new ComponentesPC("Ventilador", 25.90f, "954LO2", "Nox", "Ventilador", "Nox Hummer H-212 CPU Cooler"));

            for (ComponentesPC com : listaCom) {
                escribir.println(com.toString());
            }
        } catch (IOException ex) {
            System.out.println("No existe el fichero "+ ex.toString());
        } finally {
            escribir.close();
        }

    }

    public void verListaMerchandising(ArrayList<ComponentesPC> listaM) {
        Iterator it = listaM.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void ordenarCom(ArrayList<ComponentesPC> listaCom) {
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
                    Collections.sort(listaCom, new Comparator<ComponentesPC>() {
                        @Override
                        public int compare(ComponentesPC pc1, ComponentesPC pc2) {
                            return new Float(pc1.getPrecio()).compareTo(new Float(pc2.getPrecio()));
                        }
                    });
                    verListaMerchandising(listaCom);
                    break;
                case 2:
                    Collections.sort(listaCom, new Comparator<ComponentesPC>() {
                        @Override
                        public int compare(ComponentesPC pc2, ComponentesPC pc1) {
                            return new Float(pc1.getPrecio()).compareTo(new Float(pc2.getPrecio()));
                        }
                    });
                    verListaMerchandising(listaCom);
                    break;
                case 3:
                    Collections.sort(listaCom);
                    verListaMerchandising(listaCom);
                    break;
                case 4:
                    Comparator<ComponentesPC> comparador = Collections.reverseOrder();
                    Collections.sort(listaCom, comparador);
                    verListaMerchandising(listaCom);
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
