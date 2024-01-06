package org.example.structural.bridge.bridgePatternFixed

/**
 * Solution 2: Constants
 */
const val RIFLE_DAMAGE = 3L
const val REGULAR_SPEED: Meters = 1

/**
 * Riffle Weapon
 */
class Rifle : Weapon {
    override fun attack() = RIFLE_DAMAGE
}

/**
 * FLameThrower Weapon, double damage than Rifle
 */
class Flamethrower : Weapon {
    override fun attack() = RIFLE_DAMAGE * 2
}

/**
 * Batton Weapon, triple damage than Rifle
 */
class Batton : Weapon {
    override fun attack() = RIFLE_DAMAGE * 3
}

class RegularLegs : Legs {
    override fun move() = REGULAR_SPEED
}

class AthleticLegs : Legs {
    override fun move() = REGULAR_SPEED * 2
}

fun main() {
    val stormTrooper = StormFixedTrooper(Rifle(), RegularLegs())
    val flameTrooper =
        StormFixedTrooper(
            Flamethrower(),
            RegularLegs(),
        )
    val scoutTrooper = StormFixedTrooper(Rifle(), AthleticLegs())
}
