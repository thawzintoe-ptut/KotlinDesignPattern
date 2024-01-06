package org.example.structural.proxy

import java.net.URL

/**
 * the Proxy design pattern extends an object's functionality.
 * However, unlike a decorator, which always does what it's told, having
 * a proxy may mean that when asked to do something, the object does something totally different.
 */
class ProxyIntro

/**
 * The Proxy design pattern is divided into three sub-patterns:
 * 1. Virtual proxy: Lazily caches the result
 * 2. Remote proxy: Issues a call to the remote resource
 * 3. Protection or access control proxy: Denies access to unauthorized parties
 */
class ProxyDesignPattern

/**
 * Proxying and delegation is a very useful approach for many complex problems
 */
class ProxyImportantNote

/**
 * Solution: Lazy delegation
 */
data class CatImage(
    val thumbnailUrl: String,
    val url: String,
) {
    val image: ByteArray by lazy {
// Read image as bytes
        URL(url).readBytes()
    }
}
