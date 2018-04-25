package com.rbc.rbcone.studygroup.kotlin.examples.reifiedtypes

import java.math.BigDecimal

fun main(args: Array<String>) {

    val list1 = MyList(1, 2, 3, 4, 5)
    val list2 = MyList("one", "two", "three")
    val list3 = MyList(BigDecimal("1.5"), BigDecimal("-4.7"))
    val list4 = MyList(1, 2.3, -5.1f) // : MyList<Number>

    list1.printContents()
    list2.printContents()
    list3.printContents()
    list4.printContents()

    /*
    list1.printType()
    list2.printType()
    list3.printType()
    list4.printType()
    */
}

class MyList<T>(vararg initialContents: T) {
    private val contents = mutableListOf(*initialContents)

    fun printContents() {
        println("The contents in this list are: ${contents.joinToString()}")
    }
}

/*
fun <T> MyList<T>.printType() {
    println("This list contains elements of type: ${T::class}")
}
*/

/*
inline fun <reified T> MyList<T>.printType() {
    println("This list contains elements of type: ${T::class}")
}
*/

/*
fun <T> printTypeWrapper(myList: MyList<T>) {
    myList.printType()
}
*/
