package org.example.structural.adapter

/**
 * USPlug assumes that power is Int. It has 1 as its value
 */
interface USPlug {
    val hasPower: Int
}

/**
 * EUPlug treats power as String, which is either TRUE or FALSE:
 */
interface EUPlug {
    val hasPower: String // "TRUE" or "FALSE"
}

/**
 * For UsbMini, power is an enum:
 */
interface UsbMini {
    val hasPower: Power
}

/**
 * For USB-TypeC,power is a boolean value
 */
interface UsbTypeC {
    val hasPower: Boolean
}
