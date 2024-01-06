package org.example.structural.composite

import org.example.structural.bridge.Trooper
import org.example.structural.bridge.bridgePatternFixed.RegularLegs
import org.example.structural.bridge.bridgePatternFixed.Rifle
import org.example.structural.bridge.bridgePatternFixed.StormFixedTrooper

/**
 * Shouldn't this design pattern encompass all the others?
 * Lieutenants of the Empire quickly discover that no matter how well-equipped,
 * stormtroopers cannot hold their ground against the rebels because they are uncoordinated.
 */
class CompositeIntro

val bobaFett = StormFixedTrooper(Rifle(), RegularLegs())
val squad = Squad(listOf(bobaFett, bobaFett, bobaFett))

class Squad(private val units: List<Trooper>) : Trooper {
    override fun move(
        x: Long,
        y: Long,
    ) {
        for (u in units) {
            u.move(x, y)
        }
    }

    override fun attack(
        x: Long,
        y: Long,
    ) {
        for (u in units) {
            u.attack(x, y)
        }
    }

    override fun retreat() {
        TODO("Not yet implemented")
    }
}
