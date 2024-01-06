package org.example.structural.flyweight

/**
 * Solution: Saving Memory
 * What's the problem we have with all of our snails?
 * What if we extract those sprites into a Singleton object or a Factory Method and then only reference them from each instance?
 */
object SnailSprites {
    val sprites =
        List(8) { i ->
            java.io.File(
                when (i) {
                    0 -> "snail-left.jpg"
                    1 -> "snail-right.jpg"
                    in 2..4 -> "snail-move-left-${i - 1}.jpg"
                    else -> "snail-move-right${(4 - i)}.jpg"
                },
            )
        }
}

class TansanianSnail() {
    val directionFacing = Direction.LEFT
    val sprites = SnailSprites.sprites
}
