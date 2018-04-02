package com.rbc.rbcone.studygroup.kotlin.examples.covariance

import java.math.BigDecimal

fun main(args: Array<String>) {

    val list1: MyList<Int> = MyList(1, 2, 3, 4, 5)
    val list2: MyList<String> = MyList("one", "two", "three")
    val list3: MyList<BigDecimal> = MyList(BigDecimal("1.5"), BigDecimal("-4.7"))
    val list4: MyList<Number> = MyList(1, 2.3, -5.1f)

    // println(sum(list1))
    // println(sum(list2))
    // println(sum(list3))
    println(sum(list4))
}

class MyList<T>(vararg initialContents: T): Iterable<T> {
    private val contents = mutableListOf(*initialContents)

    fun printContents() {
        println("The contents in this list are: ${contents.joinToString()}")
    }

    override fun iterator(): Iterator<T> = contents.iterator()
}

fun sum(myList: MyList<Number>): Double =
    myList.iterator().asSequence().sumByDouble { it.toDouble() }



/**
 * Kotlin has the notion of 'in' and 'out' positions.
 * When a type parameter is covariant, we can only use them in an 'out' position.
 * Function arguments are in the 'in' position and function return types are in the 'out' position.
 *
 * A couple of exceptions:
 * - Constructor parameters don't have parameters in 'in' and 'out' positions, because
 *   it is only called when the instance is created. However, we cannot declare a 'var' parameter as covariant,
 *   as Kotlin generates a setter for it and that would violate its property of being in the 'out' position.
 * - Private functions does not have the concept of 'in' and 'out' positions,
 *   because the outside world cannot call them.
 */