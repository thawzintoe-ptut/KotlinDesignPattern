package org.example.creational.abstractFactory

/**
 * Step1: Define Abstract Product Interfaces
 * Each type of furniture (Chair, Sofa, CoffeeTable) will have its own interface defining the methods that concrete products must implement.
 */
fun interface Chair {
    fun sitOn()
}

fun interface Sofa {
    fun layOn()
}

fun interface CoffeeTable {
    fun putCoffee(coffeeType: String)
}

/**
 * Step2: Implement Concrete Products
 * implement these interfaces for each style variant (Modern, Victorian, ArtDeco).
 */
// chair
class ModernChair : Chair {
    override fun sitOn() = println("Sitting on Modern Chair")
}
class VictorianChair : Chair {
    override fun sitOn() = println("Sitting on Victorian Chair")
}
// sofa
class ModernSofa : Sofa {
    override fun layOn() = println("Lying on Modern Sofa")
}
class VictorianSofa : Sofa {
    override fun layOn() = println("Lying on Victorian Sofa")
}
// coffee table
class ModernCoffeeTable : CoffeeTable {
    override fun putCoffee(coffeeType: String) =
        println("Putting $coffeeType on Modern Coffee Table")
}
class VictorianCoffeeTable : CoffeeTable {
    override fun putCoffee(coffeeType: String) =
        println("Putting $coffeeType on Victorian Coffee Table")
}

/**
 * Step 3: Declare the Abstract Factory Interface
 * Declare methods for creating each type of furniture.
 */
interface FurnitureFactory {
    fun createChair(): Chair
    fun createSofa(): Sofa
    fun createCoffeeTable(): CoffeeTable
}

/**
 * Step 4: Create Concrete Factories
 * Implement these methods to create concrete products.
 */
class ModernFurnitureFactory : FurnitureFactory {
    override fun createChair(): Chair {
        return ModernChair()
    }

    override fun createSofa(): Sofa {
        return ModernSofa()
    }

    override fun createCoffeeTable(): CoffeeTable {
        return ModernCoffeeTable()
    }
}

class VictorianFurnitureFactory : FurnitureFactory {
    override fun createChair(): Chair {
        return VictorianChair()
    }

    override fun createSofa(): Sofa {
        return VictorianSofa()
    }

    override fun createCoffeeTable(): CoffeeTable {
        return VictorianCoffeeTable()
    }
}

/**
 * Step 5: Use the Abstract Factory
 * Use the factory to create products.
 */
class FurnitureStore(private val factory: FurnitureFactory) {
    private lateinit var chair: Chair
    private lateinit var sofa: Sofa
    private lateinit var coffeeTable: CoffeeTable

    fun furnishRoom() {
        chair = factory.createChair()
        sofa = factory.createSofa()
        coffeeTable = factory.createCoffeeTable()

        chair.sitOn()
        sofa.layOn()
        coffeeTable.putCoffee("Espresso")
    }
}

fun main() {
    // The factory type can be determined at runtime based on configuration or environment
    val modernFurnitureFactory = ModernFurnitureFactory()
    val moderFurnitureStore = FurnitureStore(modernFurnitureFactory)
    moderFurnitureStore.furnishRoom()

    // The factory type can be determined at runtime based on configuration or environment
    val victorianFurnitureFactory = VictorianFurnitureFactory()
    val victorianFurnitureStore = FurnitureStore(victorianFurnitureFactory)
    victorianFurnitureStore.furnishRoom()
}