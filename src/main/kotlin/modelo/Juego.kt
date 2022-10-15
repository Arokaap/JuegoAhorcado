package modelo

import recursos.Utilidades
import java.lang.StringBuilder

class Juego(jugadores: Jugador) {
    private var jugador: Jugador
    private var intentos: Byte = 5
    private var frases: Array<String> = arrayOf(
        "cangrejo", "sapo", "caiman", "iguana", "salamandra", "sacacorchos", "ronronear",
        "sanguijuela", "hamburguesa", "manijero"
    )

    init {
        this.jugador = jugadores
    }

    fun getIntentos(): Byte {
        return this.intentos
    }

    fun iniciarJuego() {
        var victoria: Boolean
        var error: Boolean
        var frase = generarFrase()
        var guiones = StringBuilder("")

        for (letra in frase) {
            guiones.append("_")
        }

        do {
            Utilidades.textoInformativo("Te quedan ${this.intentos} vidas")
            println(guiones)
            var opcionElegida = Utilidades.pedirString("Introduzca una letra: ")
            var letraAcertada = false
            victoria = true
            error = false

            if (opcionElegida.trim().length == 1) {
                for (index in frase.indices) {
                    if (opcionElegida.trim().equals(frase[index].toString(), true)) {
                        guiones[index] = opcionElegida.trim().get(0)
                        Utilidades.limpiarPantalla()
                        letraAcertada = true
                    }

                    if (guiones[index].equals('_', true)) {
                        victoria = false
                    }
                }
            } else {
                Utilidades.limpiarPantalla()
                Utilidades.textoError("Debes usar una letra!")
                victoria = false
                error = true
            }

            if (!letraAcertada && !victoria && !error) {
                Utilidades.limpiarPantalla()
                this.intentos--
                if (this.intentos < 1) {
                    Utilidades.textoError("Te has quedado sin vidas, intentalo en la proxima.")
                } else if (!error) {
                    Utilidades.textoError("Fallaste :(")
                }
            } else if (!error) {
                if (victoria == true) {
                    Utilidades.textoVerde("VICTORIA!")
                    Utilidades.textoVerde("La palabra era: ${frase}")
                } else {
                    Utilidades.textoVerde("PALABRA CORRECTA")
                }
            }

        } while (this.intentos > 0 && victoria == false)


    }

    private fun generarFrase(): String {
        return frases[((Math.random() * (9 - 0 + 1)).toInt() + 0)]
    }

    companion object {
        fun menuInicial(): Byte {
            val sb = StringBuilder("\n\n\u001b[33;1m--------MENU---------")
                .append("\n1. Iniciar partida")
                .append("\n2. Creditos")
                .append("\n3. Salir\u001b[0m")

            println(sb)

            return Utilidades.pedirByte("Introduzca una opción:")
        }
    }
}