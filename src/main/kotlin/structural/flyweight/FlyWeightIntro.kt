package org.example.structural.flyweight

import java.io.File

/**
 * Flyweight is an object without any state. The name comes from it being very light.
 * the data class related to the Flyweight design pattern at all?
 */
class FlyWeightIntro

/**
 * Being conservative
 */
class TanzanianSnail {
    private val directionFacing = Direction.LEFT
    private val sprites =
        List(8) { i ->
            File(
                when (i) {
                    0 -> "snail-left.jpg"
                    1 -> "snail-right.jpg"
                    in 2..4 -> "snail-move-left-${i - 1}.jpg"
                    else -> "snail-move-right${(4 - i)}.jpg"
                },
            )
        }

    // More information about the state of a snail comes
    // This may include its health, for example
    fun getCurrentSprint(): File {
        return when (directionFacing) {
            Direction.LEFT -> sprites[0]
            Direction.RIGHT -> sprites[1]
        }
    }
}

/**
 * ach snail has only two directions of movement: LEFT and RIGHT.
 */
enum class Direction {
    LEFT,
    RIGHT,
}
