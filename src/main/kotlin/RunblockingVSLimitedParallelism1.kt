package org.example

import kotlinx.coroutines.*

suspend fun main() {
    //runBlocking()
    defaultLimitedParallelism()
}

fun runBlocking() {
    runBlocking {
        delay(1000L)
        println("World!")
    }
    runBlocking {
        delay(1000L)
        println("World!")
    }
    runBlocking {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun defaultLimitedParallelism() = coroutineScope {
    val dispatcher = Dispatchers.Default.limitedParallelism(1)
    launch(dispatcher) {
        delay(1000L)
        println("World!")
    }
    launch(dispatcher) {
        delay(1000L)
        println("World!")
    }
    launch(dispatcher) {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}

