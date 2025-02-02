class Cuenta(val numeroCuenta: Int, var saldoDisponible: Double) {
    companion object {
        fun esMoroso(persona: Persona): Boolean {
            return persona.listaCuentas.any { it?.saldoDisponible ?: 0.0 < 0 }
        }

        fun transferencia(persona: Persona, personaB: Persona, numeroCuenta: Int, numeroCuentaB: Int, cantidad: Double): Boolean {
            val cuentaOrigen = persona.listaCuentas.find { it?.numeroCuenta == numeroCuenta }
            val cuentaDestino = personaB.listaCuentas.find { it?.numeroCuenta == numeroCuentaB }

            if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.saldoDisponible >= cantidad) {
                cuentaOrigen.saldoDisponible -= cantidad
                cuentaDestino.saldoDisponible += cantidad
                return true
            }
            return false
        }
    }

    fun consultarSaldo(): Double = saldoDisponible

    fun recibirAbono(cantidad: Double) {
        saldoDisponible += cantidad
    }

    fun realizarPago(cantidad: Double) {
        saldoDisponible -= cantidad
    }
}

class Persona(val dni: String) {
    val listaCuentas: Array<Cuenta?> = Array(3) { null }

    init {
        require(listaCuentas.size <= 3) { "Una persona no puede tener más de 3 cuentas." }
    }

    fun agregarCuenta(cuenta: Cuenta) {
        if (listaCuentas.any { it?.numeroCuenta == cuenta.numeroCuenta }) {
            println("La cuenta ya existe en la lista.")
            return
        }

        for (i in listaCuentas.indices) {
            if (listaCuentas[i] == null) {
                listaCuentas[i] = cuenta
                println("Cuenta agregada correctamente.")
                return
            }
        }
        println("No se ha podido agregar la cuenta a la lista.")
    }
}

fun main() {
    val cuenta1 = Cuenta(1, 0.0)
    val cuenta2 = Cuenta(2, 700.0)
    val juanPersona = Persona("54675893N")
    juanPersona.agregarCuenta(cuenta1)
    juanPersona.agregarCuenta(cuenta2)
    cuenta1.recibirAbono(1100.0)
    cuenta2.realizarPago(750.0)
    println(if (Cuenta.esMoroso(juanPersona)) "Es moroso" else "No es moroso")
    Cuenta.transferencia(juanPersona, juanPersona, 1, 2, 1000.0)
    println(if (Cuenta.esMoroso(juanPersona)) "Es moroso" else "No es moroso")
}