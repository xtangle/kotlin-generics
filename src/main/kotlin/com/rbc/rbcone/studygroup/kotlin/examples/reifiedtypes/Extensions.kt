package com.rbc.rbcone.studygroup.kotlin.examples.reifiedtypes

fun main(args: Array<String>) {

    println(TypeRange<Any, Int>())
    // println(TypeRange<Int, Any>())
    println(TypeRange<Unit?, Nothing?>())

}

class TypeRange<A, B : A> {

    /*
    override inline fun toString(): String {
        return "TypeRange: [${A::class}, ${B::class}]"
    }
    */
}




































/*
inline fun <reified A, reified B : A> TypeRange<A, B>.toString(): String {
    return "TypeRange: [${A::class}, ${B::class}]"
}
*/
