package com.rbc.rbcone.studygroup.kotlin.assignment.solutions

import java.util.function.BiFunction

fun main(args: Array<String>) {

    /**
     * 2. Write a function named 'merge' such that the following uncommented code
     *    compiles and prints the correct output.
     */

    val a = listOf("a", "b", "c")
    a.sorted()
    /*



     */

}

fun <U: Comparable<U>, V: Comparable<V>> merge(iterable1: Iterable<U>,
                                               iterable2: Iterable<V>,
                                               comparator: BiFunction<U, V, Int>): List<Any> {
/*
    val result: MutableList<Any> = mutableListOf()
    val uIter = iterable1.sorted().iterator()
    val vIter = iterable2.sorted().iterator()
    loop@while (true) {
        val u = if (uIter.hasNext()) uIter.next() else null
        val v = if (vIter.hasNext()) vIter.next() else null

        when {
            u == null && v == null -> break@loop
            u != null && v == null -> result.add(u)
            u == null && v != null -> result.add(v)
            u != null && v != null ->
                when (comparator.apply(u, v)) {
                    0 ->
                }
        }
    }
    return result*/
}