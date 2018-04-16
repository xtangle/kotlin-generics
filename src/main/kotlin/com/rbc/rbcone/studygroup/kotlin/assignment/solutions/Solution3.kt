package com.rbc.rbcone.studygroup.kotlin.assignment.solutions

import io.kotlintest.shouldBe
import java.math.BigDecimal

fun main(args: Array<String>) {

    val source = setOf(1L, "fall", 4.0, 6, "summer", BigDecimal.ONE, 'c')

    /**
     * Write a function named 'extractTypes' such that the following uncommented code compiles and the tests pass.
     */

    val src1: MutableSet<Any> = source.toMutableSet()
    val dest1: MutableList<Number> = mutableListOf()
    extractTypes(src1, dest1)
    src1 shouldBe mutableSetOf("fall", "summer", 'c')
    dest1 shouldBe mutableListOf(1L, 4.0, 6, BigDecimal.ONE)

    val src2: MutableList<Any> = source.toMutableList()
    val dest2: MutableSet<Any> = mutableSetOf("summer", 1L, "spring")
    extractTypes<String>(src2, dest2)
    src2 shouldBe mutableListOf(1L, 4.0, 6, BigDecimal.ONE, 'c')
    dest2 shouldBe mutableSetOf(1L, "spring", "fall", "summer")
}

inline fun <reified T> extractTypes(source: MutableCollection<*>, destination: MutableCollection<in T>) =
    source.apply {
        filterIsInstanceTo(destination, T::class.java)
        removeAll { it is T }
    }
