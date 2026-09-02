package com.edu.udistrital.gestionrpg.rpg.manager.backend;

import co.edu.udistrital.gestionrpg.modelo.Personaje;
import co.edu.udistrital.gestionrpg.modelo.RepositorioPersonajes;
import io.javalin.Javalin;

        
public class RpgManagerBackend {
    public static void main(String[] args) {
        // Javalin puerto 7070 habilitando la carpeta de archivos estaticos "public"
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public"); //Lee los archivos desde la carpeta "public" 
        }).start(7070);

        // Ruta GET para obtener la lista de personajes en formato JSON
        app.get("/personajes", ctx -> {
            ctx.json(RepositorioPersonajes.getListaPersonajes());
        });
        
        // Ruta POST para agregar/crear un personaje en la lista de personajes (Formulario HTML)
        app.post("/personajes", ctx -> {
             
            //1. Extraccion de cada campo que viene del formulario HTML
             String nombre = ctx.formParam("nombre");
             int nivel = Integer.parseInt(ctx.formParam("nivel"));
             int vida = 100;
             String clase = ctx.formParam("clase");
             
            //2. Creacion de un nuevo personaje con los datos extraidos del formulario HTML
            Personaje nuevo = new Personaje(nombre, nivel, vida, clase);
            
            //3. Agregamos el nuevo personaje a la lista de personajes
            RepositorioPersonajes.getListaPersonajes().add(nuevo);

            //4. Redirigimos de vuelta a la vista para ver los cambios
            ctx.redirect("/personajes.html");

            //5. Redirigimos de vuelta a la vista para ver los cambios y mostrar un mensaje de exito
            ctx.redirect("/personajes.html?creado=true");

        });
    }
}
