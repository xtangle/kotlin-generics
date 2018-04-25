package com.rbc.rbcone.studygroup.kotlin.examples.sequences

fun main(args: Array<String>) {

    val iterator = IntRange(0, 10).iterator()
    val sequence: Sequence<Int> = iterator.asSequence()
    println(sequence.joinToString())

    /*
    val naturalNumbers: Sequence<Int> = generateSequence(0) {it + 1}
    println(naturalNumbers.take(10).toList())
    */

    /*
    val zero = sequenceOf(0)
    val binaryCoefficients = generateSequence(sequenceOf(1)) { (zero + it + zero).zipWithNext { a, b -> a + b } }
    binaryCoefficients.take(10).forEach { println(it.joinToString(" ")) }
    */

    /*
    val primes = generateSequence(2 to generateSequence(3) {it + 2}) {
        val currSeq = it.second.iterator()
        val nextPrime = currSeq.next()
        nextPrime to currSeq.asSequence().filterNot { it % nextPrime == 0 }
    }.map { it.first }
    println(primes.take(10).toList())
    */
}