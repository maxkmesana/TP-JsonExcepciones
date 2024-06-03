package org.TPJson.Model.Entity;

import java.util.Objects;

public class Contacto {
    private static int cont = 0;
    private final int id;
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.id = ++cont;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     *
     * @param id ID PARA SER BUSCADO
     * SOLO DEBERIA SER USADO PARA HACER BUSQUEDAS POR ID.D
     */
    public Contacto(int id){
        this.email = "";
        this.telefono = "";
        this.nombre = "";
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return id == contacto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
