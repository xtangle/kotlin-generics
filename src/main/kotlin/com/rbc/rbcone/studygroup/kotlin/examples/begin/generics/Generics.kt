package com.rbc.rbcone.studygroup.kotlin.examples.begin.generics

import java.math.BigDecimal

fun main(args: Array<String>) {
    val list1 = MyList(1, 2, 3, 4, 5)
    val list2 = MyList("one", "two", "three")
    val list3 = MyList(BigDecimal("1.5"), BigDecimal("-4.7"))
    val list4 = MyList(1, 2.3, -5.1f)
}

class MyList (private vararg val contents: Any?)
