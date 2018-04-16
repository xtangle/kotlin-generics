package com.rbc.rbcone.studygroup.kotlin.examples.contravariance

import java.math.BigDecimal

fun main(args: Array<String>) {

    val list1: MyList<Int> = MyList(1, 2, 3, 4, 5)
    val list2: MyList<String> = MyList("one", "two", "three")
    val list3: MyList<BigDecimal> = MyList(BigDecimal("1.5"), BigDecimal("-4.7"))
    val list4: MyList<Number> = MyList(1, 2.3, -5.1f)

    // list1.printContents(numberFormatter)
    list2.printContents(stringFormatter)
    // list3.printContents(numberFormatter)
    list4.printContents(numberFormatter)

    // list1.printContents{ numberFormatter.format(it) } // Works because lambda is of type Function1
}

class MyList<T>(vararg initialContents: T) {
    private val contents = mutableListOf(*initialContents)

    fun add(element: T) {
        this.contents.add(element)
    }

    fun printContents(formatter: Formatter<T>) {
        println("The contents in this list are: ${contents.joinToString { formatter.format(it) }}")
    }

    fun printContents(transformer: (T) -> String) {
        println("The contents in this list are: ${contents.joinToString(transform = transformer)}")
    }
}

interface Formatter<T> {
    fun format(element: T): String
}

val stringFormatter = object: Formatter<String> {
    override fun format(element: String) = "'$element'"
}

val numberFormatter = object: Formatter<Number> {
    override fun format(element: Number) = BigDecimal(element.toString()).setScale(4).toPlainString()
}
