package com.rbc.rbcone.studygroup.kotlin.examples.end.sequences

fun main(args: Array<String>) {

    val naturalNumbers = generateSequence(0) {it + 1}
    println(naturalNumbers.take(10).toList())

    val fibonacci = generateSequence(0 to 1) { it.second to it.first + it.second }.map { it.first }
    println(fibonacci.take(10).toList())

    val primes = generateSequence(2 to generateSequence(3) {it + 2}) {
        val currSeq = it.second.iterator()
        val nextPrime = currSeq.next()
        nextPrime to currSeq.asSequence().filterNot { it % nextPrime == 0 }
    }.map { it.first }
    println(primes.take(10).toList())
}