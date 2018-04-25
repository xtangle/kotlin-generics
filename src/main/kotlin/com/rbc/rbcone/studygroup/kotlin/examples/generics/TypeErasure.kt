package com.rbc.rbcone.studygroup.kotlin.examples.generics

fun main(args: Array<String>) {

    val strings = listOf("1", "2", "3")

    println(strings is List)
    println(strings is List<String>) // Works because check is made at compile time.
    println(strings is List<CharSequence>) // Works if type matches a subtype.
    // println(strings is List<Int>) // When type doesn't match, we get compiler error.
    println(strings is List<*>) // "Star projection", i.e. wildcard
    println()

    /*
    val anys: List<Any> = listOf("1", "2", "3")

    println(anys is List)
    // println(anys is List<String>) // error: Cannot check for instance of erased type: List<String>
    println()
    */

    /*
    val listAny: List<Any> = listOf(1, 2, 3)
    if (listAny is List<*>) {
        println("From herein this list shall contain strings")
        // Runtime cast, compiler gives a warning: Unchecked cast: List<Any> to List<String>
        val strList = listAny as List<String>
        println(strList)

        // Only when we use it as a String do we get an exception.
        // error: java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        println(strList[1].replace("2", "two"))

        // If we had defined listAny = listOf(1, "2", 3), then we don't get any exception.
        // The cast happens at runtime.
    }
    */
}