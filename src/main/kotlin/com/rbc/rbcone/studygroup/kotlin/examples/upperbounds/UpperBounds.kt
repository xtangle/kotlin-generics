package com.rbc.rbcone.studygroup.kotlin.examples.upperbounds

import java.math.BigDecimal

fun main(args: Array<String>) {

    val list1 = MyList(1, 2, 3, 4, 5)
    val list2 = MyList("one", "two", "three")
    val list3 = MyList(BigDecimal("1.5"), BigDecimal("-4.7"))
    val list4 = MyList(1, 2.3, -5.1f)

    list1.printContents()
    list2.printContents()
    list3.printContents()
    list4.printContents()
}

class MyList<T>(vararg initialContents: T) /*where T: Number, T: Comparable<T>*/ {
    private val contents = mutableListOf(*initialContents)

    fun printContents() {
        println("The contents in this list are: ${contents.joinToString()}")
    }
}
