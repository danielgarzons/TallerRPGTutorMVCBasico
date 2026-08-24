class Personaje:

    def __init__(self, nombre: str, clase: str, nivel: int, vida: int):
        self.nombre: str = nombre
        self.clase: str = clase
        self.nivel: int = nivel
        self.vida: int = vida

    def to_dict(self):
        return {
            "nombre": self.nombre,
            "clase": self.clase,
            "nivel": self.nivel,
            "vida": self.vida
        }