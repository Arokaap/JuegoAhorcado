import modelo.Juego
import modelo.Jugador
import recursos.Utilidades

fun main() {
    var repetir: Boolean = true

    do {
        when (Juego.menuInicial()) {
            1.toByte() -> {
                var partida = Juego(Jugador("001", "Aroka", "Aarón"))

                Utilidades.limpiarPantalla()
                partida.iniciarJuego()
            }

            2.toByte() -> {
                Utilidades.limpiarPantalla()
                println("Todos los creditos reservados a:")
                Utilidades.textoVerde("Aarón Aragón Aroca")
            }

            3.toByte() -> {
                Utilidades.limpiarPantalla()
                Utilidades.textoVerde("Gracias por jugar!")
                repetir = false
            }

            else -> {
                Utilidades.limpiarPantalla()
                Utilidades.textoError("Opción incorrecta")
            }
        }
    } while (repetir)
}