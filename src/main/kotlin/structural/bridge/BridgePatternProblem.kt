package org.example.structural.bridge

interface Trooper {
    fun move(
        x: Long,
        y: Long,
    )

    fun attack(
        x: Long,
        y: Long,
    )

    fun retreat()
}

open class StormTrooper : Trooper {
    override fun move(
        x: Long,
        y: Long,
    ) {
        // Move at normal speed
        TODO("Not yet implemented")
    }

    override fun attack(
        x: Long,
        y: Long,
    ) {
        // Missed most of the time
        TODO("Not yet implemented")
    }

    override fun retreat() {
        TODO("Not yet implemented")
    }
}

open class ShockTrooper : Trooper {
    override fun move(
        x: Long,
        y: Long,
    ) {
        // Moves slower than regular StormTrooper
        TODO("Not yet implemented")
    }

    override fun attack(
        x: Long,
        y: Long,
    ) {
        // Sometimes hits
        TODO("Not yet implemented")
    }

    override fun retreat() {
        TODO("Not yet implemented")
    }
}

/**
 * Stronger Version of StormTrooper
 */
class RiotControlTrooper : StormTrooper() {
    override fun attack(
        x: Long,
        y: Long,
    ) {
        // Has an electric baton, stay away!
        super.attack(x, y)
    }
}

/**
 * Stronger Version of ShockTrooper
 */
class FlameTrooper : ShockTrooper() {
    override fun attack(
        x: Long,
        y: Long,
    ) {
        // Uses flamethrower, dangerous!
        super.attack(x, y)
    }
}

class ScoutTrooper : ShockTrooper() {
    override fun move(
        x: Long,
        y: Long,
    ) {
// Runs faster
    }
}

/**
 * One day, our dear designer comes and asks that all stormtroopers should be able to shout,each will have a different phrase.
 * Without thinking twice, we add a new function to our interface:
 */
interface Infantry {
    fun move(
        x: Long,
        y: Long,
    )

    fun attack(
        x: Long,
        y: Long,
    )

    fun shout(): String
}
