package org.example.creational.singleton

fun main() {
    // CompanionSingleton
    CompanionSingleton.getInstance()
    // EagerInitialization
    EagerInitialization
    // LazyInitialization
    LazyInitialization.instance
    // DoubleLocking
    DoubleLocking.getInstance()
    // Enum
    Enum.INSTANCE
}