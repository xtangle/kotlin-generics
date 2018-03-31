package com.rbc.rbcone.studygroup.kotlin.assignment.solutions

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.math.BigDecimal
import java.time.LocalDate

fun main(args: Array<String>) {

    val json1 = "{\"id\": 1, \"content\": \"Apple\"}"
    val json2 = "{\"id\": 2, \"content\": 10}"
    val json3 = "{\"id\": 3, \"content\": \"2018-03-14\"}"
    val json4 = "{\"id\": 4, \"content\": \"-371.48000\"}"

    /**
     * 1. Write a function named 'toKotlinObject' such that the following uncommented code
     *    compiles and prints the correct output.
     *    (Hint: use the jacksonObjectMapper function provided by the jackson-module-kotlin library)
     */

    val obj1: Response<String> = json1.toKotlinObject()
    val obj2: Response<Int> = json2.toKotlinObject()
    val obj3: Response<LocalDate> = json3.toKotlinObject()
    val obj4: Response<BigDecimal> = json4.toKotlinObject()

    println(obj1) // Response(id=1, content=Apple)
    println(obj2) // Response(id=2, content=10)
    println(obj3) // Response(id=3, content=2018-03-14)
    println(obj4) // Response(id=4, content=-371.48000)
}

data class Response<out T>(val id: Int, val content: T)

inline fun <reified T> String.toKotlinObject(): T =
    jacksonObjectMapper().readValue(this, T::class.java)
