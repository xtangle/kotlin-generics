package com.rbc.rbcone.studygroup.kotlin.assignment.problems

fun main(args: Array<String>) {

    /**
     * A 'lucky' number is a natural number generated by a sieve, similar to how prime numbers are generated,
     * but instead of eliminating numbers based on their value, it eliminates them based on their position in
     * the remaining set. They are generated by the following procedure:
     *
     *   Start with the natural numbers. Delete every 2nd number, leaving 1 3 5 7 9 11 13 15 17 19 21 23 ...;
     *   the 2nd number remaining is 3, so delete every 3rd number, leaving 1 3 7 9 13 15 19 21 ...;
     *   the 3rd number remaining is 7, so delete every 7th number, leaving 1 3 7 9 13 15 21 ...;
     *   the 4th number remaining is 9, so delete every 9th number;
     *   ... etc.
     *
     * The first 10 lucky numbers are:
     *   1, 3, 7, 9, 13, 15, 21, 25, 31, 33, ...
     *
     * Write a sequence using generateSequence() that lazily generates the lucky numbers and makes the tests pass.
     */

    // val luckyNumbers = TODO("not implemented")

    /*
    luckyNumbers.take(10).toList().let { println(it); it shouldBe listOf(1, 3, 7, 9, 13, 15, 21, 25, 31, 33) }
    mapOf(100 to 615, 1000 to 8827, 10000 to 115597).mapKeys { luckyNumbers.elementAt(it.key) }
        .forEach { actual, expected -> println(actual); actual shouldBe expected }

    val n = 100000
    val actualDensity = (luckyNumbers.takeWhile { it <= n }.count().toDouble() / n)
        .also { println("Actual density of lucky numbers <= $n: $it") }
    val expectedDensity = (1.0 / kotlin.math.ln(n.toDouble()))
        .also { println("Expected density of lucky numbers <= $n: $it") }
    actualDensity shouldBe expectedDensity.plusOrMinus(0.001)
    */
}
