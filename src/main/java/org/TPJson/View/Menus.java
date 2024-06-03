package org.TPJson.View;

import org.TPJson.Controller.ControllerContacto;

import java.util.Scanner;

public class Menus {
    private final ControllerContacto controllerContacto;

    public Menus(ControllerContacto controllerContacto) {
        this.controllerContacto = controllerContacto;
    }

    public void menu(){
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.println("""
                    --- MENU PRINCIPAL ---
                    > CONTACTOS:
                    1- Agregar un contacto.
                    2- Mostrar agenda completa.
                    3- Actualizar un contacto.
                    4- Eliminar un contacto.
                    0 - Salir.
                    """);
            System.out.print("Ingrese una opcion: ");
            int opcion = scn.nextInt();

            switch (opcion){
                case 1:
                    controllerContacto.create();
                    break;
                case 2:
                    controllerContacto.mostrar();
                    break;
                case 3:
                    controllerContacto.updateWhole();
                    break;
                case 4:
                    controllerContacto.delete();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion ingresada es invalida. Intente nuevamente.\n");
                    break;
            }
        }
    }
}
