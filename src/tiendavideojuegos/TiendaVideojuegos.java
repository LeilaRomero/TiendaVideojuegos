/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendavideojuegos;

import inventario.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import productos.ComponentesPC;
import productos.Merchandising;
import productos.Videojuegos;

/**
 *
 * @author Josemolamazo
 */
public class TiendaVideojuegos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Empleado em = new Empleado();
        ArrayList<Empleado> listaEm = new ArrayList();

        ListasVideojuegos listaVJ = new ListasVideojuegos();
        ArrayList<Videojuegos> lista = new ArrayList();
        listaVJ.crearListaVideojuegos("inventarioVJ.txt", lista);

        ListaMerchandising listaM = new ListaMerchandising();
        ArrayList<Merchandising> lista2 = new ArrayList();
        listaM.crearListaMerchandising("inventarioM.txt", lista2);

        ListaComponentesPC listaCom = new ListaComponentesPC();
        ArrayList<ComponentesPC> lista3 = new ArrayList();
        listaCom.crearListaComponentesPC("inventarioPC.txt", lista3);

        boolean salir = false;
        int opcion;
        while (!salir) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("***MENU EMPLEADO***"
                    + "\n 1. Crear sesion"
                    + "\n 2. Salir"));
            try {
                switch (opcion) {
                    case 1:
                        em.crearSesion("sesiones.txt", listaEm);
                        while (!salir) {
                            opcion = Integer.parseInt(JOptionPane.showInputDialog("***MENU PRINCIPAL***"
                                    + "\n 1. Comprar videojuegos"
                                    + "\n 2. Vender videojuegos"
                                    + "\n 3. Comprar merchandising"
                                    + "\n 4. Vender merchandising"
                                    + "\n 5. Comprar componentes PC"
                                    + "\n 6. Vender componentes PC"
                                    + "\n 7. Ver listas de Videojuegos"
                                    + "\n 8. Ordenar listas de videojuegos"
                                    + "\n 9. Ver listas de merchandising"
                                    + "\n 10. Ordenar listas de merchandising"
                                    + "\n 11. Ver listas de componentes"
                                    + "\n 12. Ordenar listas de componentes"
                                    + "\n 13. Salir"));

                            switch (opcion) {
                                case 1:
                                    em.comprarVJ("inventarioVJ.txt", lista);
                                    break;
                                case 2:
                                    em.venderVJ(new File("inventarioVJ.txt"), "inventarioVJ.txt", lista);
                                    break;
                                case 3:
                                    em.comprarMerch("inventarioM.txt", lista2);
                                    break;
                                case 4:
                                    em.venderMerch(new File("inventarioM.txt"), "inventarioM.txt", lista2);
                                    break;
                                case 5:
                                    em.comprarComPC(new File("inventarioPC.txt"), "inventarioPC.txt", lista3);
                                    break;
                                case 6:
                                    em.venderComPC(new File("inventarioPC.txt"), "inventarioPC.txt", lista3);
                                    break;
                                case 7:
                                    listaVJ.verListaVideojuegos(lista);
                                    break;
                                case 8:
                                    listaVJ.ordenarVJ(lista);
                                    break;
                                case 9:
                                    listaM.verListaMerchandising(lista2);
                                    break;
                                case 10:
                                    listaM.ordenarMer(lista2);
                                    break;
                                case 11:
                                    listaCom.verListaMerchandising(lista3);
                                    break;
                                case 12:
                                    listaCom.ordenarCom(lista3);
                                    break;
                                case 13:
                                    menu();
                            }

                        }

                    case 2:
                        System.exit(0);

                }

            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }
}
