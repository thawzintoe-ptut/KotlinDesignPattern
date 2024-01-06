package org.example.structural.adapter

fun USPlug.toEuPlug(): EUPlug {
    val hasPower =
        if (this.hasPower == 1) {
            "TRUE"
        } else {
            "FALSE"
        }
    return object : EUPlug {
        override val hasPower: String
            get() = hasPower
    }
}

fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower =
        when (this.hasPower) {
            Power.TRUE -> true
            Power.FALSE -> false
        }
    return object : UsbTypeC {
        override val hasPower: Boolean
            get() = hasPower
    }
}

fun main() {
    cellPhone(
        charger(
            usPowerOutlet().toEuPlug(),
        ).toUsbTypeC(),
    )
}
