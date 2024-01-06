package org.example.structural.bridge.bridgePatternFixed

import org.example.structural.bridge.Trooper

/**
 * Solution 1: Typealias
 */
typealias PointsOfDamage = Long

typealias Meters = Int

interface Weapon {
    fun attack(): PointsOfDamage
}

interface Legs {
    fun move(): Meters
}

class StormFixedTrooper(
    private val weapon: Weapon,
    private val legs: Legs,
) : Trooper {
    override fun move(
        x: Long,
        y: Long,
    ) {
        legs.move()
    }

    override fun attack(
        x: Long,
        y: Long,
    ) {
        weapon.attack()
    }
}
