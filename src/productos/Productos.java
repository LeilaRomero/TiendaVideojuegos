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
public class Productos{

    private float precio;
    private String id, nombre, nombreEmpresa;

    public Productos() {
    }

    public Productos(String nombre, float precio, String id, String nombreEmpresa) {
        this.precio = precio;
        this.id = id;
        this.nombre = nombre;
        this.nombreEmpresa = nombreEmpresa;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }


    @Override
    public String toString() {
        return "nombre = " + nombre +" , precio =" + precio + ", id = " + id +  " , nombreEmpresa = " + nombreEmpresa;
    }
    

}
