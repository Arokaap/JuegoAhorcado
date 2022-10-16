package modelo

class Jugador(id: String, nick: String, nombre: String) {
    private var id: String
    private var nick: String
    private var nombre: String

    init {
        this.id = id
        this.nick = nick
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Jugador $id" +
                "\nNick = $nick" +
                "\nNombre = $nombre"
    }


}