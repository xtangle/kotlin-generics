package com.rbc.rbcone.studygroup.kotlin.assignment.problems

fun main(args: Array<String>) {

    /**
     * Write an extension function named 'merge' for a Sequence with comparable elements.
     * When another sequence of the same type is pass as an argument, it returns a new sequence which produces
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

    /*
    val s1 = sequenceOf(4, 6, -3, 1)
    val s2 = sequenceOf(3, 2, 4, 7, -1)
    s1.merge(s2).toList() shouldBe listOf(3, 2, 4, 4, 6, -3, 1, 7, -1)

    val s3 = sequenceOf("John", "Mary", "Trent")
    val s4 = sequenceOf("Anna", "Joe", "Nathan", "Zack")
    s3.merge(s4).toList() shouldBe listOf("Anna", "Joe", "John", "Mary", "Nathan", "Trent", "Zack")

    emptySequence<Int>().merge(emptySequence()).toList() shouldBe emptyList()
    */
}
