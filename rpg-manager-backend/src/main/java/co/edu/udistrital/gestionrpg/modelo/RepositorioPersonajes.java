package co.edu.udistrital.gestionrpg.modelo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPersonajes {
    
    private static final List<Personaje> listaPersonajes = new ArrayList<>();
    
    static{
        listaPersonajes.add(new Personaje("Alekei", 5, 100, "Guerrero"));
        listaPersonajes.add(new Personaje("Gandalf", 10, 80, "Mago"));
    }
    // Uso del constructor "Personaje"
    public static List<Personaje> getListaPersonajes(){
        return listaPersonajes;
    }
}
