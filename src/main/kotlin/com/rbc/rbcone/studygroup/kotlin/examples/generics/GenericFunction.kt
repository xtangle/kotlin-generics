package com.rbc.rbcone.studygroup.kotlin.examples.generics

fun main(args: Array<String>) {

    println(multiply(3))
    println(multiply(4.2))
    println(multiply(multiply("Hello")))

    /*
    listOf(1, 2, 3, 4, 5).print()
    listOf("Abe", "Beth", "Ether").print()
    */
}

fun <T> multiply(item: T): Pair<T, T> = item to item

/*
fun <T> Iterable<T>.print() {
    for (item in this) {
        println(item)
    }
    println()
}
*/
