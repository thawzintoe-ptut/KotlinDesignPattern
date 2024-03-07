package org.example.creational.factory

fun interface Authenticator{
    fun authenticate()
}

fun GoogleAuthenticator(): Authenticator {
    return Authenticator {
        println("Authenticating with Google")
    }
}

fun FacebookAuthenticator(): Authenticator {
    return Authenticator {
        println("Authenticating with Facebook")
    }
}

