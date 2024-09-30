package org.example

import kotlinx.coroutines.*

suspend fun main() {
    coroutineScope {
        withContext(Dispatchers.Unconfined) {
            launch {
                println(Thread.currentThread().name)
                delay(1000)
                println(Thread.currentThread().name)
            }
        }
    }
}