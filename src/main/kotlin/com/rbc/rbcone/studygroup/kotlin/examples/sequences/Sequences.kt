package com.rbc.rbcone.studygroup.kotlin.examples.sequences

fun main(args: Array<String>) {

    /**
     * Every function call in a chain of function calls for collections creates an intermediate collection instance
     * One way to avoid the creation of intermediate instances is using sequences.
     * Another use case for sequences is when we don't know how large a collection will be.
     *
     * Sequences is pretty much the same as "streams" in Java.
     * Kotlin re-implemented this because Java streams aren't available in every platform
     *   (eg. on Android in the past, Java 8 is not fully supported).
     * One way to view sequences (streams) is as a continuous stream of elements.
     * Like streams in Java, there are two types of operations on sequences:
     *   - intermediate operation - return a sequence and are LAZY
     *   - terminal operations - return a concrete collection or value and
     *       evaluates intermediate operations in an optimized manner
     *
     * Note: We ONLY want to use sequences when we have a large collection, because Kotlin
     *   collections when they're small are very efficient.
     */

    val names = listOf("Steve", "John", "Joe", "Mary", "Jane")

    names.filter { println("filtering $it"); it.startsWith('J') } // ["John", "Joe", "Jane"]
        .map { println("mapping $it");it.toUpperCase() } // ["JOHN", "JOE", "JANE"]
        .find { println("finding $it"); it.endsWith('E') } // "JOE"
        .also { println(it); println() }

    names.asSequence()
        .filter { println("filtering $it"); it.startsWith('J') }
        .map { println("mapping $it");it.toUpperCase() }
        .find { println("finding $it"); it.endsWith('E') }
        .also { println(it); println() }

}
