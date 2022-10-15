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

    fun getId(): String {
        return id
    }

    fun setId(value: String) {
        id = value
    }

    fun getNick(): String {
        return nick
    }

    fun setNick(value: String) {
        nick = value
    }

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(value: String) {
        nombre = value
    }

    override fun toString(): String {
        return "Jugador $id" +
                "\nNick = $nick" +
                "\nNombre = $nombre"
    }


}