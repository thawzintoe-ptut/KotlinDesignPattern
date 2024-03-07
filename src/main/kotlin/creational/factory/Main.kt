package org.example.creational.factory

fun main() {
    val googleAuthenticator = AuthenticatorFactory.createAuthenticator(AuthenticatorType.GOOGLE)
    googleAuthenticator.authenticate()
    val facebookAuthenticator = AuthenticatorFactory.createAuthenticator(AuthenticatorType.FACEBOOK)
    facebookAuthenticator.authenticate()
}