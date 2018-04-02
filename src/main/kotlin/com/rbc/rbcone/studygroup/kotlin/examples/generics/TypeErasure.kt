package com.rbc.rbcone.studygroup.kotlin.examples.generics

fun main(args: Array<String>) {

    val strings = listOf("1", "2", "3")

    println(strings is List)
    println(strings is List<String>) // Works because check is made at compile time. Even the IDE knows.
    println(strings is List<*>) // "Star projection", i.e. wildcard
    println()

    /*
    val strings2: List<Any> = listOf("1", "2", "3")

    println(strings2 is List)
    // println(strings2 is List<String>) // error: Cannot check for instance of erased type: List<String>
    println()
    */

    /*
    // What about casting with generics?
    val listAny = listOf(1, 2, 3)
    if (listAny is List<*>) {
        println("From herein this list shall contain strings")
        // Runtime cast, compiler gives a warning: Unchecked cast: List<Any> to List<String>
        val strList = listAny as List<String>
        // error: java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        println(strList[1].replace("str", "string"))
        // If we had defined listAny = listOf(1, "str", 3), then we don't get any exception,
        // confirming that the cast happens at runtime
    }
    */
}