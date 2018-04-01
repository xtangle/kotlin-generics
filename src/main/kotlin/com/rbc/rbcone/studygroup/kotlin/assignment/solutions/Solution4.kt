package com.rbc.rbcone.studygroup.kotlin.assignment.solutions

import io.kotlintest.shouldBe
import java.util.*

fun main(args: Array<String>) {

    /**
     * Write an extension function named 'merge' for a Sequence with comparable elements.
     * When another sequence of the same type is passed as an argument, it returns a new sequence which produces
     * whichever current element that is smaller between the two sequences. If the two sequences produces elements
     * that are equal, the one from the first sequence is taken. For example, given two sequences s1 and s2:
     *
     *   s1 = 4, 6, -3, 1
     *   s2 = 3, 2, 4, 7, -1
     *
     * The resulting merged sequence should be:
     *
     *   s1.merge(s2) = 3, 2, 4, 4, 6, -3, 1, 7, -1
     *
     * Of course, if elements in both sequences are sorted, then the merged sequence will be sorted as well.
     *
     * Implement the 'merge' function and make the tests pass.
     */

    val s1 = sequenceOf(4, 6, -3, 1)
    val s2 = sequenceOf(3, 2, 4, 7, -1)
    s1.merge(s2).toList() shouldBe listOf(3, 2, 4, 4, 6, -3, 1, 7, -1)

    val s3 = sequenceOf("John", "Mary", "Trent")
    val s4 = sequenceOf("Anna", "Joe", "Nathan", "Zack")
    s3.merge(s4).toList() shouldBe listOf("Anna", "Joe", "John", "Mary", "Nathan", "Trent", "Zack")

    emptySequence<Int>().merge(emptySequence()).toList() shouldBe emptyList()
}

fun <T : Comparable<T>> Sequence<T>.merge(other: Sequence<T>): Sequence<T> = object : Sequence<T> {
    val iterator1 = this@merge.iterator()
    val iterator2 = other.iterator()

    override fun iterator(): Iterator<T> = object : Iterator<T> {
        var value1 = getNextValue(iterator1)
        var value2 = getNextValue(iterator2)

        override fun hasNext(): Boolean = value1 !== null || value2 !== null

        override fun next(): T {
            val val1 = value1
            val val2 = value2
            return if (val1 !== null && (val2 === null || val1 <= val2)) {
                value1 = getNextValue(iterator1)
                val1
            } else if (val2 !== null) {
                value2 = getNextValue(iterator2)
                val2
            } else {
                throw NoSuchElementException()
            }
        }

        private fun getNextValue(iterator: Iterator<T>): T? = if (iterator.hasNext()) iterator.next() else null
    }
}
