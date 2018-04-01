package com.rbc.rbcone.studygroup.kotlin.assignment.problems

fun main(args: Array<String>) {

    val json1 = """{"id": 1, "content": "Apple"}"""
    val json2 = """{"id": 2, "content": 10}"""
    val json3 = """{"id": 3, "content": "-371.48000"}"""
    val json4 = """{"id": 4, "content": {"first": "a", "second": 4}}"""

    /**
     * Write an extension function named 'toKotlinObject' such that the following uncommented code compiles
     * and the tests pass.
     * (Hint: use the 'jacksonObjectMapper' factory provided by the jackson-module-kotlin library
     * and call its 'readValue' function)
     */

    /*
    val obj1: Response<String> = json1.toKotlinObject()
    val obj2: Response<Int> = json2.toKotlinObject()
    val obj3: Response<BigDecimal> = json3.toKotlinObject()
    val obj4: Response<Pair<Char, Double>> = json4.toKotlinObject()

    obj1 shouldBe Response(1, "Apple")
    obj2 shouldBe Response(2, 10)
    obj3 shouldBe Response(3, BigDecimal("-371.48000"))
    obj4 shouldBe Response(4, 'a' to 4.0)
    */
}

data class Response<out T>(val id: Int, val content: T)
