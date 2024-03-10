package org.example.creational.singleton

class LazyInitialization private constructor(){
    companion object {
        val instance: LazyInitialization by lazy { LazyInitialization() }
    }
}