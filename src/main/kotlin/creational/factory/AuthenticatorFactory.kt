package org.example.creational.factory

object AuthenticatorFactory {
    fun createAuthenticator(type: AuthenticatorType): Authenticator {
        return when (type) {
            AuthenticatorType.GOOGLE -> GoogleAuthenticator()
            AuthenticatorType.FACEBOOK -> FacebookAuthenticator()
        }
    }
}