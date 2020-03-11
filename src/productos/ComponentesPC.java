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
public class ComponentesPC extends Productos implements Comparable<ComponentesPC> {

    private String tipo, descripcion;

    public ComponentesPC() {
    }

    public ComponentesPC(String nombre, float precio, String id, String nombreEmpresa, String tipo, String descripcion) {
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
        return super.toString() + " , tipo = " + tipo + " , descripcion = " + descripcion;
    }

    @Override
    public int compareTo(ComponentesPC t) {
        return super.getNombre().compareToIgnoreCase(t.getNombre());
    }

}
