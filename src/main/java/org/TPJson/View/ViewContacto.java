package org.TPJson.View;

import org.TPJson.Excepciones.ExcepcionDatosVacios;
import org.TPJson.Model.Entity.Contacto;

import java.util.Scanner;

public class ViewContacto {

    public Contacto create() throws ExcepcionDatosVacios{
        Scanner scn = new Scanner(System.in);

        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scn.nextLine();

        System.out.print("Ingrese el numero del contacto: ");
        String telefono = scn.nextLine();

        System.out.print("Ingrese el email del contacto: ");
        String email = scn.nextLine();

        if(nombre.isBlank() || telefono.isBlank() || email.isBlank()){
            throw new ExcepcionDatosVacios();
        }

        return new Contacto(nombre, telefono, email);
    }

    /**
     * @param msj Mensaje a mostrar. Ejemplo: "Ingrese id de contacto a eliminar: "
     * @return retorna un id para buscarlo en Repository (a eliminar o actualizar)
     */
    public int getId(String msj){
        Scanner scn = new Scanner(System.in);

        System.out.print(msj);
        return scn.nextInt();
    }

    public String updateNombre() throws ExcepcionDatosVacios{
        Scanner scn = new Scanner(System.in);

        System.out.print("Ingrese el nombre a actualizar: ");
        String nombre = scn.nextLine();
        if(nombre.isBlank()){
            throw new ExcepcionDatosVacios("Error: Nombre no puede ser un campo en blanco/vacio.");
        }
        return nombre;
    }

    public String upadteTelefono() throws ExcepcionDatosVacios{
        Scanner scn = new Scanner(System.in);

        System.out.print("Ingrese el telefono a actualizar: ");
        String telefono = scn.nextLine();
        if(telefono.isBlank()){
            throw new ExcepcionDatosVacios("Error: Telefono no puede ser un campo en blanco/vacio.");
        }
        return telefono;
    }

    public String updateEmail() throws ExcepcionDatosVacios{
        Scanner scn = new Scanner(System.in);

        System.out.print("Ingrese el email a actualizar: ");
        String email = scn.nextLine();
        if(email.isBlank()){
            throw new ExcepcionDatosVacios("Error: Email no puede ser un campo en blanco/vacio.");
        }
        return email;
    }

    public void mostrar(Contacto contacto){
        System.out.println("ID: "+contacto.getId());
        System.out.println("Nombre: "+contacto.getNombre());
        System.out.println("Telefono: "+contacto.getTelefono());
        System.out.println("Email: "+contacto.getEmail());
    }


}
