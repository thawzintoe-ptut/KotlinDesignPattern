package org.example.structural.decorator

const val DEFAULT_SHIP_NAME = "Thaw Enterprise"
const val DEFAULT_CAPTAIN_NAME = "Ptut"
const val UNKNOWN = "Unknown"

// Unfixed Decorator Pattern
open class UnFixedShipRepository {
    private val shipCaptain = mutableMapOf(DEFAULT_SHIP_NAME to DEFAULT_CAPTAIN_NAME)

    open fun getCaptain(shipName: String): String = shipCaptain[shipName] ?: UNKNOWN

    open fun addCaptain(
        shipName: String,
        captainName: String,
    ) {
        shipCaptain[shipName] = captainName
    }
}

class LoggingGetCaptainRepository : UnFixedShipRepository() {
    override fun getCaptain(shipName: String): String {
        println("Getting captain for $shipName")
        return super.getCaptain(shipName)
    }
}

class ValidatingAddCaptainRepository : UnFixedShipRepository() {
    override fun addCaptain(
        shipName: String,
        captainName: String,
    ) {
        if (captainName.length > 15) {
            throw RuntimeException("$captainName is longer than 20 characters!")
        }
        super.addCaptain(shipName, captainName)
    }
}

/**
 * Fixed with Decorator design pattern
 * The purpose of the Decorator design pattern is to add new behaviors to our objects dynamically.
 * In our example, logging and validating are two behaviors
 * That's why we sometimes want to be applied to our object and sometimes don't want to be applied.
 * We'll start by converting our ShipRepository into an interface:
 */
interface ShipRepository {
    fun addCaptain(
        shipName: String,
        captainName: String,
    )

    fun getCaptain(shipName: String): String
}

/**
 * we'll implement that interface using the same logic as before:
 */
class DefaultShipRepository : ShipRepository {
    private val shipCaptain = mutableMapOf("Thaw Enterprise" to "Ptut")

    override fun getCaptain(shipName: String): String = shipCaptain[shipName] ?: "Unknown"

    override fun addCaptain(
        shipName: String,
        captainName: String,
    ) {
        shipCaptain[shipName] = captainName
    }
}

/**
 * The by keyword delegates the implementation of an interface to another object.
 * In this case, the hardest part to understand is the signature. What we need from the Decorator design pattern is as follows:
 * • We need to be able to receive the object we're decorating.
 * • We need to be able to keep a reference to the object.
 * • When our decorator is called, we need to be able to decide if we would like to change the behavior of the object we're holding or to delegate the call.
 * • We need to be able to extract an interface or have one provided already by the (library) author.
 */
class LoggingGetCaptainShipRepository(
    private val repository: ShipRepository,
) : ShipRepository by repository {
    override fun getCaptain(shipName: String): String {
        println("Getting captain for $shipName")
        return repository.getCaptain(shipName)
    }
}

/**
 * the same with LoggingShipRepository
 */
class ValidationAddCaptainShipRepository(
    private val repository: ShipRepository,
) : ShipRepository by repository {
    private val maximumLength = 15

    override fun addCaptain(
        shipName: String,
        captainName: String,
    ) {
        if (captainName.length > 15) {
            throw RuntimeException("$captainName is longer than 20 characters!")
        }
        repository.addCaptain(shipName, captainName)
    }
}

fun main() {
    val starTrekRepository = DefaultShipRepository()
    val withValidating = ValidationAddCaptainShipRepository(starTrekRepository)
    val withLoggingAndValidating =
        LoggingGetCaptainShipRepository(withValidating)
    withLoggingAndValidating.getCaptain(DEFAULT_SHIP_NAME)

    // Maximum Length for captainName is greater than 15 case
    withLoggingAndValidating.addCaptain(
        "SJ Enterprise",
        "Sheilar June My Love",
    )
}
