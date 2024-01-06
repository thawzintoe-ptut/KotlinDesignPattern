package org.example.structural.adapter

/**
 * Our goal is to bring the power value from a US power outlet to our cellphone,
 * which will be represented by this function:
 */
fun cellPhone(chargeCable: UsbTypeC) {
    if (chargeCable.hasPower) {
        println("I've Got The Power!")
    } else {
        println("No power")
    }
}

// Power outlet exposes USPlug interface
fun usPowerOutlet(): USPlug {
    return object : USPlug {
        override val hasPower: Int
            get() = 1
    }
}

// Charger accepts EUPlug interface and exposes UsbMini
fun charger(euPlug: EUPlug): UsbMini {
    return object : UsbMini {
        override val hasPower: Power
            get() = Power.valueOf(euPlug.hasPower)
    }
}
