package org.example.structural.decorator

interface OperatorShipRepository {
    operator fun get(starshipName: String): String

    operator fun set(
        starshipName: String,
        captainName: String,
    )
}

class OperatorOverloading : OperatorShipRepository {
    private val shipCaptain = mutableMapOf(DEFAULT_SHIP_NAME to DEFAULT_CAPTAIN_NAME)

    override fun get(starshipName: String): String = shipCaptain[starshipName] ?: UNKNOWN

    override fun set(
        starshipName: String,
        captainName: String,
    ) {
        shipCaptain[starshipName] = captainName
    }
}

fun main() {
    val operator = OperatorOverloading()
    val captainName = operator[DEFAULT_SHIP_NAME]
    print(captainName)
    operator["ASDF Ship"] = "ASDFGHJKL"
}
