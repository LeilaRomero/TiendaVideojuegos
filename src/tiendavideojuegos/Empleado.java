/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendavideojuegos;

import Excepcion.ExcepcionContraseña;
import Excepcion.ExcepcionDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import librerias.Datos;
import productos.*;

/**
 *
 * @author Josemolamazo
 */
public class Empleado {

    TiendaVideojuegos obx = new TiendaVideojuegos();

    PrintWriter escribir = null;
    FileWriter fich;
    Scanner sc;

    private String nombre, contrasenha, id;

    public Empleado() {
    }

    public Empleado(String nombre, String contraseña, String id) {
        this.nombre = nombre;
        this.contrasenha = contraseña;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void crearSesion(String nomeFichero, ArrayList<Empleado> listaEm) throws ExcepcionContraseña {
        try {
            String contrasenha1, contrasenha2;
            fich = new FileWriter(nomeFichero, true);
            escribir = new PrintWriter(fich);
            nombre = librerias.Datos.pedirString("Nombre: ");

            contrasenha1 = librerias.Datos.pedirString("Contrasenha: ");
            contrasenha2 = librerias.Datos.pedirString("Repita contrasenha: ");
            if (!(contrasenha1.equals(contrasenha2))) {

                throw new ExcepcionContraseña("La contrasenha tiene que coincidir");

            } else {

                id = String.valueOf(Math.floor(Math.random() * (101 - 1)));
                listaEm.add(new Empleado(nombre, contrasenha1, id));
                for (int i = 0; i < listaEm.size(); i++) {
                    escribir.println(listaEm.get(i).toString());
                }

            }
        } catch (IOException ex) {
            System.out.println("No existe el fichero" + ex.toString());
        } finally {
            escribir.close();
        }

    }

    public void iniciarSesion(File file, ArrayList<Empleado> listaEm) throws ExcepcionDatos {
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                nombre = librerias.Datos.pedirString("Nombre: ");
                contrasenha = librerias.Datos.pedirString("Contrasenha: ");
                String[] cadena = sc.nextLine().split(",");
                String[] cadenaNombre = cadena[0].split("=");
                String[] cadenaContraseña = cadena[1].split("=");
                String nombreEm = cadenaNombre[1];
                String contraseñaEm = cadenaContraseña[1];
                if (!(nombreEm.equals(nombre)) || !(contraseñaEm.equals(contrasenha))) {
                    throw new ExcepcionDatos("Error al introducir los datos");
                } else {
                    obx.menu();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero" + ex.toString());
        } finally {
            sc.close();
        }
    }

    public void comprarVJ(String fichero, ArrayList<Videojuegos> listaVJ) {

        try {

            fich = new FileWriter(fichero, true);
            escribir = new PrintWriter(fich);
            Videojuegos vj = new Videojuegos(librerias.Datos.pedirString("Nombre del videojuego: "),
                    librerias.Datos.pedirFloat("Precio del videojuego: "), librerias.Datos.pedirString("Nuevo id: "),
                    librerias.Datos.pedirString("Nombre de la empresa: "), librerias.Datos.pedirString("Plataforma: "),
                    librerias.Datos.pedirInt("Edad minima: "), librerias.Datos.pedirString("Genero del videojuego: "));

            listaVJ.add(vj);
            escribir.println(vj.toString());

        } catch (IOException ex) {
            System.out.println("No existe el fichero " + ex.toString());
        } finally {
            escribir.close();
        }
    }
    public void venderVJ(File file, String fichero, ArrayList<Videojuegos> listaVJ) {
        try {

            for (Videojuegos x : listaVJ) {
                System.out.println(x.toString());
            }
            String nombreId = librerias.Datos.pedirString("Buscar id del juego: ");
            fich = new FileWriter(fichero);
            escribir = new PrintWriter(fich);

            for (int i = 0; i < listaVJ.size(); i++) {
                if (nombreId.equals(listaVJ.get(i).getId())) {
                    listaVJ.remove(listaVJ.get(i));

                }

            }
        } catch (IOException ex) {
            System.out.println("No existe el fichero" + ex.toString());
        } finally {
            for (Videojuegos y : listaVJ) {
                escribir.println(y.toString());
            }
            escribir.close();
        }
    }

    public void comprarMerch(String fichero, ArrayList<Merchandising> listaM) {

        try {

            fich = new FileWriter(fichero, true);
            escribir = new PrintWriter(fich);
            Merchandising merch = new Merchandising(librerias.Datos.pedirString("Nombre del producto: "),
                    librerias.Datos.pedirString("Tipo de producto: "), librerias.Datos.pedirString("Descripcion: "),
                    librerias.Datos.pedirFloat("Precio del producto: "), librerias.Datos.pedirString("Nueva id: "),
                    librerias.Datos.pedirString("Nombre de la empresa: "));
            listaM.add(merch);
            escribir.println(merch.toString());

        } catch (IOException ex) {
            System.out.println("No existe el fichero " + ex.toString());
        } finally {
            escribir.close();

        }

    }

    public void venderMerch(File file, String fichero, ArrayList<Merchandising> listaM) {
        try {

            for (Merchandising x : listaM) {
                System.out.println(x.toString());
            }
            String nombreId = librerias.Datos.pedirString("Buscar id del producto: ");
            fich = new FileWriter(fichero);
            escribir = new PrintWriter(fich);

            for (int i = 0; i < listaM.size(); i++) {
                if (nombreId.equals(listaM.get(i).getId())) {
                    listaM.remove(listaM.get(i));

                }

            }
        } catch (IOException ex) {
            System.out.println("No existe el fichero" + ex.toString());
        } finally {
            for (Merchandising y : listaM) {
                escribir.println(y.toString());
            }
            escribir.close();

        }
    }

    public void comprarComPC(File file, String fichero, ArrayList<ComponentesPC> listaPC) {

        try {

            fich = new FileWriter(fichero, true);
            escribir = new PrintWriter(fich);
            ComponentesPC cpc = new ComponentesPC(librerias.Datos.pedirString("Nombre del componente: "),
                    librerias.Datos.pedirFloat("Precio del componente: "), librerias.Datos.pedirString("Nuevo id: "),
                    librerias.Datos.pedirString("Nombre de la empresa: "), librerias.Datos.pedirString("Tipo de componente: "),
                    librerias.Datos.pedirString("Descripcion: "));
            listaPC.add(cpc);
            escribir.println(cpc.toString());

        } catch (IOException ex) {
            System.out.println("No existe el fichero " + ex.toString());
        } finally {
            escribir.close();

        }

    }

    public void venderComPC(File file, String fichero, ArrayList<ComponentesPC> listaPC) {
        try {

            for (ComponentesPC x : listaPC) {
                System.out.println(x.toString());
            }
            String nombreId = librerias.Datos.pedirString("Buscar id del producto: ");
            fich = new FileWriter(fichero);
            escribir = new PrintWriter(fich);

            for (int i = 0; i < listaPC.size(); i++) {
                if (nombreId.equals(listaPC.get(i).getId())) {
                    listaPC.remove(listaPC.get(i));

                }

            }
        } catch (IOException ex) {
            System.out.println("No existe el fichero" + ex.toString());
        } finally {
            for (ComponentesPC y : listaPC) {
                escribir.println(y.toString());
            }
            escribir.close();

        }
    }

    @Override
    public String toString() {
        return "nombre =" + nombre + ", contrasenha =" + contrasenha + ", id = " + id;
    }

}
