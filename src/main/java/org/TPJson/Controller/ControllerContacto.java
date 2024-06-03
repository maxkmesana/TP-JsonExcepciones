package org.TPJson.Controller;

import org.TPJson.Excepciones.ExcepcionDatosVacios;
import org.TPJson.Model.Entity.Contacto;
import org.TPJson.Model.Repository.Agenda;
import org.TPJson.View.ViewContacto;

import java.util.Set;

public class ControllerContacto {
    private final ViewContacto viewContacto;
    private final Agenda repoContacto;

    public ControllerContacto(ViewContacto viewContacto, Agenda repoContacto) {
        this.viewContacto = viewContacto;
        this.repoContacto = repoContacto;
    }

    public void create(){
        try {
            Contacto contacto = viewContacto.create();
            repoContacto.addContacto(contacto);
        } catch (ExcepcionDatosVacios e) {
            System.out.println(e.getMessage());
            System.out.println("El contacto no fue aniadido a la agenda. \n");
        }
    }

    // busqueda: returns null or contacto


    public void updateWhole(){
        int idBuscado = viewContacto.getId("Ingrese el id del contacto a actualizar: ");
        Contacto buscado = repoContacto.buscarContacto(idBuscado);
        if(buscado != null){

            try {
                String nombre = viewContacto.updateNombre();
                String telefono = viewContacto.upadteTelefono();
                String email = viewContacto.updateEmail();
                repoContacto.updateContacto(buscado, nombre, telefono, email);
            } catch (ExcepcionDatosVacios e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void delete(){
        int idBuscado = viewContacto.getId("Ingrese el id del contacto a eliminar: ");
        Contacto buscado = repoContacto.buscarContacto(idBuscado);
        if(buscado != null){
            repoContacto.delete(buscado);
        }
    }

    public void mostrar(){
        Set<Contacto> set = repoContacto.getSet();
        for (Contacto c : set){
            viewContacto.mostrar(c);
        }
    }

}
