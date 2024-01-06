package org.example.structural.composite

import org.example.structural.bridge.Trooper

class SquadWithSecondaryConstructor(
    private val units: List<Trooper>,
) : Trooper {
    constructor() : this(listOf())
    constructor(t1: Trooper) : this(listOf(t1))
    constructor(t1: Trooper, t2: Trooper) : this(listOf(t1, t2))

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
