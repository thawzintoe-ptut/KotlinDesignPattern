package org.example.structural.composite

import org.example.structural.bridge.Trooper

class VarArgSquad(
    private val units: List<Trooper>,
) : Trooper {
    constructor(vararg units: Trooper) :
        this(units.toList())

    override fun move(
        x: Long,
        y: Long,
    ) {
        TODO("Not yet implemented")
    }

    override fun attack(
        x: Long,
        y: Long,
    ) {
        TODO("Not yet implemented")
    }

    override fun retreat() {
        TODO("Not yet implemented")
    }
}
