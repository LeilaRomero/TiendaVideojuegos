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
public class Merchandising extends Productos implements Comparable<Merchandising>{
    private String tipo, descripcion;

    public Merchandising() {
    }

    public Merchandising(String nombre, String tipo, String descripcion, float precio, String id, String nombreEmpresa) {
        super(nombre, precio, id, nombreEmpresa);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    @Override
    public String toString() {
        return super.toString()+" , tipo = " + tipo + " , descripcion = " + descripcion;
    }

    @Override
    public int compareTo(Merchandising t) {
        return super.getNombre().compareToIgnoreCase(t.getNombre());
    }
}
