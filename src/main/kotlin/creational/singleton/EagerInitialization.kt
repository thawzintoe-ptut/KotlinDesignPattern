package org.example.creational.singleton

/**
 * The object keyword in Kotlin is used to declare a singleton class, also known as an object declaration.
 * An object declaration is a concise way of creating a singleton class without the need to define a class and a companion object.
 * It is an example of eager initialization, which creates the singleton when the class is first accessed.
 * The instance remains in memory until the application is terminated:
 */
object EagerInitialization {
    fun doSomething() = "Doing something"
}