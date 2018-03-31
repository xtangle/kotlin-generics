package com.rbc.rbcone.studygroup.kotlin.examples.end.generics

import java.math.BigDecimal

fun main(args: Array<String>) {

    val list1 = MyList(1, 2, 3, 4, 5)
    //val list2 = MyList("one", "two", "three")
    val list3 = MyList(BigDecimal("1.5"), BigDecimal("-4.7"))
    //val list4 = MyList(1, 2.3, -5.1f)

    list1.printContents()
    //list2.printContents()
    list3.printContents()
    //list4.printContents()

    list1.printType()
    //list2.printType()
    list3.printType()
    //list4.printType()
}

class MyList<T>(private vararg val contents: T): Iterable<T> where T: Number, T: Comparable<T> {

    override fun iterator(): Iterator<T> = object: Iterator<T> {
        private var index = 0
        override fun hasNext(): Boolean = index < contents.size
        override fun next(): T = contents[index++]
    }
}

fun <T> MyList<T>.printContents() where T: Number, T: Comparable<T> {
    println("The contents in this list are: ${this.joinToString()}")
}

inline fun <reified T> MyList<T>.printType() where T: Number, T: Comparable<T> {
    println("This list contains elements of type: ${T::class}")
}
