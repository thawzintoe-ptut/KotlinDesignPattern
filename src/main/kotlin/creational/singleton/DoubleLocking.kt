package org.example.creational.singleton

/**
 * Double-checked locking is a mechanism to reduce the overhead of synchronization by checking the lock only once and
 * creating the instance only if the lock is not already held by another thread
 */
class DoubleLocking private constructor(){
    companion object {
        @Volatile
        private var instance: DoubleLocking? = null
        fun getInstance(): DoubleLocking {
            if(instance == null){
                synchronized(this){
                    if(instance == null){
                        instance = DoubleLocking()
                    }
                }
            }
            return instance!!
        }
    }
}