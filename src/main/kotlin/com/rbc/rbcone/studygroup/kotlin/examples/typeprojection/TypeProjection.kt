package com.rbc.rbcone.studygroup.kotlin.examples.typeprojection

fun main(args: Array<String>) {

    val source: MyList<Int> = MyList(1, 2, 3, 4, 5)

    val dest1 = MyList<Int>()
    val dest2 = MyList<Number>()
    val dest3 = MyList<Any>()

    copyList(source, dest1)
    dest1.printContents()

    // copyList<Int>(source, dest2)
    // dest2.printContents()

    println(isEqual(source, dest1))
}

class MyList<T>(vararg initialContents: T): MutableIterable<T> {
    private val contents = mutableListOf(*initialContents)

    override fun iterator(): MutableListIterator<T> = contents.listIterator()

    fun printContents() {
        println("The contents in this list are: ${contents.joinToString()}")
    }
}

/**
 * Note, we only read the source and only write the destination
 * Use 'type projection', also called 'use site variance'
 * In Java, it is similar to the '?' wildcard:
 * - ? extends MyList  <==>  out T
 * - ? super MyList    <==>  in T
 */
fun <T> copyList(source: MyList<T>, destination: MyList<T>) {
    val destIterator = destination.iterator()
    while (destIterator.hasNext()) destIterator.next()
    for (element in source) {
        destIterator.add(element)
    }
}

fun isEqual(list1: MyList<*>, list2: MyList<*>): Boolean =
    list1.iterator().asSequence().toList() == list2.iterator().asSequence().toList()
