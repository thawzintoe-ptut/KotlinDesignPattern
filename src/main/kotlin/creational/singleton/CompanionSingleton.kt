package org.example.creational.singleton

/**
 * We can implement a singleton in Kotlin using a companion object.
 * It is a special type of object that is associated with a class and can be used to store static members and methods for the class.
 * To create such a singleton, we store the single instance in the companion object of the singleton class:
 */
class CompanionSingleton private constructor() {

    /**
     * @Volatile annotation is needed to ensure that the instance property is updated atomically.
     * This prevents other threads from creating more instances and breaking the singleton pattern.
     * We need the synchronized keyword in the static getInstance method to prevent accessing the method from multiple threads simultaneously.
     */
    companion object {
        @Volatile
        private var instance: CompanionSingleton? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: CompanionSingleton().also { instance = it }
        }
    }

    fun doSomething() = "Doing something"
}