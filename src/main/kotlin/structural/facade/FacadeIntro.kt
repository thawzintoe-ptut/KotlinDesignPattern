package org.example.structural.facade

import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path

/**
 * facade as a term to refer to a design pattern comes directly from building architecture
 * In programming, facades can help to hide the ugly details of an implementation.
 */
class FacadeIntro

/**
 * Depending on when you read this book, you may not need the ExperimentalPathApi annotation anymore.
 * This feature was introduced in Kotlin 1.4, and once it is stable it will be made an integral part of the language.
 */
class FacadeImportantNote

@ExperimentalPathApi
fun Server.startFromConfiguration(fileLocation: String) {
    val path = Path(fileLocation)
    val lines = path.toFile().readLines()
    val configurationPort =
        try {
            JsonParser().server(lines)
        } catch (e: RuntimeException) {
            YamlParser().server(lines)
        }
    Server.withPort(configurationPort)
}

class Server {
    companion object {
        fun withPort(configurationPort: String) {
            println(configurationPort)
        }
    }
}

interface Parser {
    fun server(line: List<String>): String
}

class JsonParser() : Parser {
    override fun server(line: List<String>): String {
        return "Json"
    }
}

class YamlParser() : Parser {
    override fun server(line: List<String>): String {
        return "YAML"
    }
}
