package com.rbc.rbcone.studygroup.kotlin.examples.generics

fun main(args: Array<String>) {

    val int = 3
    val num = 4.2
    val str = "Hello"

    println(multiply(int))
    println(multiply(num))
    println(multiply(multiply(str)))

    /*
    listOf(1, 2, 3, 4, 5).printCollection()
    listOf("Abe", "Beth", "Ether").printCollection()
    */
}

fun <T> multiply(item: T): Pair<T, T> = item to item

/*
fun <T> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
    println()
}
*/
