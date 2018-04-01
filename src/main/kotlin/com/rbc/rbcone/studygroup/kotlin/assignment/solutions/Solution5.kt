package com.rbc.rbcone.studygroup.kotlin.assignment.solutions

import io.kotlintest.shouldBe
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*


fun main(args: Array<String>) {

    val daysOfWeek = DayOfWeek.values().toSet()
    val numbers = listOf(7.7, 3.5, 4.8, 6.0, 5.1, 4.0)
    val fruits = setOf("Lemon", "Orange", "Apple", "Strawberry", "Banana", "Pear")

    /**
     * Write a function named 'mergeWith' such that the following uncommented code compiles and the tests pass.
     *
     * (Hint: You may find the 'merge' function for Sequences from Problem 4 to be useful here. Also, you may want
     * to implement a specialized comparable version of Pair)
     */

    val daysAndNumbers = daysOfWeek.mergeWith(numbers) { DayOfWeek.of(it.toInt()) }
    daysAndNumbers shouldBe listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, 3.5,
        DayOfWeek.THURSDAY, 4.0, 4.8, DayOfWeek.FRIDAY, 5.1, DayOfWeek.SATURDAY, 6.0, DayOfWeek.SUNDAY, 7.7)

    val numbersAndFruits = numbers.mergeWith(fruits) { it.length.toDouble() }
    numbersAndFruits shouldBe listOf(3.5, 4.0, "Pear", 4.8, "Apple", "Lemon", 5.1, 6.0, "Banana", "Orange", 7.7, "Strawberry")

    val fruitsAndDays = fruits.mergeWith(daysOfWeek) { it.getDisplayName(TextStyle.FULL, Locale.ENGLISH) }
    fruitsAndDays shouldBe listOf("Apple", "Banana", DayOfWeek.FRIDAY, "Lemon", DayOfWeek.MONDAY, "Orange", "Pear",
        DayOfWeek.SATURDAY, "Strawberry", DayOfWeek.SUNDAY, DayOfWeek.THURSDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY)
}

fun <U : Comparable<U>, V : Comparable<V>> Iterable<U>.mergeWith(other: Iterable<V>,
                                                                 transform: (V) -> U): List<Any?> {
    val seq1 = asSequence().sorted().map { ComparablePair(it, it) }
    val seq2 = other.asSequence().map { ComparablePair(transform(it), it) }
        .sortedWith(compareBy<ComparablePair<U, V>> { it.first }.thenBy { it.second })
    return seq1.merge(seq2).map { it.second }.toList()
}

data class ComparablePair<U : Comparable<U>, out V>(val first: U, val second: V): Comparable<ComparablePair<U, *>> {
    override fun compareTo(other: ComparablePair<U, *>) = first.compareTo(other.first)
}