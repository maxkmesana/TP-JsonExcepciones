package org.TPJson;

import org.TPJson.Controller.ControllerContacto;
import org.TPJson.Model.Repository.Agenda;
import org.TPJson.View.Menus;
import org.TPJson.View.ViewContacto;


public class Main {
    public static void main(String[] args) {
        ViewContacto viewContacto = new ViewContacto();
        Agenda repoContacto = new Agenda();
        ControllerContacto controllerContacto = new ControllerContacto(viewContacto,repoContacto);
        Menus menuPrincipal = new Menus(controllerContacto);

        menuPrincipal.menu();
    }
}