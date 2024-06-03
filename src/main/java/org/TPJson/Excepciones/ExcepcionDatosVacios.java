package org.TPJson.Excepciones;

public class ExcepcionDatosVacios extends Exception { // Deberia extender a RunTimeException??? Tal vez, no se.
    public ExcepcionDatosVacios() {
        super("Error: al menos un campo se encuentra vacio.");
    }

    public ExcepcionDatosVacios(String message) {
        super(message);
    }
}
