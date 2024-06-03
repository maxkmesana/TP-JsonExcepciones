package org.TPJson.Model.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.TPJson.Model.Entity.Contacto;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class Agenda {
    private static final String FILE_PATH = "src/main/resources/agenda.json";
    private final Gson gson = new Gson();
    private Set<Contacto> set = new HashSet<>();

    public Agenda() {
        desdeJson();
    }

    public void desdeJson(){
        try(Reader reader = new FileReader(FILE_PATH)){
            Type typeSet = new TypeToken<HashSet<Contacto>>(){}.getType();
            set = gson.fromJson(reader, typeSet);
            if(set == null){
                set = new HashSet<>();
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            set = new HashSet<>();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void aJson(){
        try(Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(set, writer);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Contacto buscarContacto(int idBuscado){
        if(!set.contains(new Contacto(idBuscado))){
            return null;
        }

        for (Contacto c : set){
            if(c.getId() == idBuscado){
                return c;
            }
        }
        return null;
    }

    public void addContacto(Contacto contacto){
        set.add(contacto);
        aJson();
    }


    public void updateContacto(Contacto contacto, String nombre, String email, String telefono){
        contacto.setNombre(nombre);
        contacto.setTelefono(telefono);
        contacto.setEmail(email);
        aJson();
    }

    public void delete(Contacto contacto){
        set.remove(contacto);
        aJson();
    }

    public Set<Contacto> getSet() {
        return set;
    }

    public int getLastId(){
        int ultimoId = Integer.MIN_VALUE;
        for (Contacto c : set){
            if(c.getId() > ultimoId){
                ultimoId = c.getId();
            }
        }

        return ultimoId;
    }
}
