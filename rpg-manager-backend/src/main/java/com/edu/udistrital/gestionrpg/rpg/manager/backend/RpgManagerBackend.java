package com.edu.udistrital.gestionrpg.rpg.manager.backend;

import io.javalin.Javalin;
import co.edu.udistrital.gestionrpg.modelo.RepositorioPersonajes;
import co.edu.udistrital.gestionrpg.modelo.Personaje;

        
public class RpgManagerBackend {
    public static void main(String[] args) {
        // Javalin puerto 7070
        Javalin app = Javalin.create().start(7070);
        
        // Ruta GET para obtener la lista de personajes
        app.get("/personajes", ctx -> {
            ctx.json(RepositorioPersonajes.getListaPersonajes());
        });
        
        app.post("/personajes", ctx -> {
             
            //1. JSON recibido (Conversión a) -> Un objeto Personaje
             Personaje nuevo = ctx.bodyAsClass(Personaje.class);
             
            //2. Agregar personaje a RepositorioPersonajes
            RepositorioPersonajes.getListaPersonajes().add(nuevo);
            
            //3. Respuesta (Mensaje o personaje creado)
            ctx.status(201).json(nuevo);
        });
    }
}
