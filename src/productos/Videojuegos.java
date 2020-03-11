/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

/**
 *
 * @author Josemolamazo
 */
public class Videojuegos extends Productos implements Comparable<Videojuegos> {

    private String plataforma, genero;
    private int edadMinima;

    public Videojuegos() {
    }

    public Videojuegos(String nombre, float precio, String id, String nombreEmpresa, String plataforma, int edadMinima, String genero) {
        super(nombre, precio, id, nombreEmpresa);
        this.plataforma = plataforma;
        this.edadMinima = edadMinima;
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }


    @Override
    public String toString() {
        return super.toString() + " , plataforma = " + plataforma + " , edadMinima = " + edadMinima + " , genero = " + genero;
    }

    @Override
    public int compareTo(Videojuegos t) {
        return super.getNombre().compareToIgnoreCase(t.getNombre());
    }
}