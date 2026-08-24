from flask import Flask, jsonify, request

from models.personaje import Personaje
from models.repository.repositorio_personajes import lista_personajes

app = Flask(__name__)

# Ruta GET para obtener la lista de personajes
@app.route("/personajes", methods=["GET"])
def obtener_personajes():

    # Convertir la lista de objetos (Personaje) a una lista de diccionarios (jsonify)
    personajes_dict = [p.to_dict() for p in lista_personajes]
    return jsonify(personajes_dict)

# Ruta POST para agregar un nuevo personaje
@app.route("/personajes", methods=["POST"])
def agregar_personaje():
    data = request.get_json()
    nombre = data.get("nombre")
    clase = data.get("clase")
    nivel = data.get("nivel")
    vida = data.get("vida")

    nuevo_personaje = Personaje (nombre, clase, nivel, vida)
    lista_personajes.append(nuevo_personaje)

    return jsonify ({"message": "Personaje agregado existosamente"})

# Punto de entrada de la app Flask
if __name__ == "__main__":
    app.run(debug=True, port=5000)


