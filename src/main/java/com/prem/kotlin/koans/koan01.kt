package com.prem.kotlin.koans

import com.prem.kotlin.Person

fun start(): String = "ok"

val startText : String by Person("Albert", "Einstein")
val endText : String by lazy { "this is the end" }


fun main(args: Array<String>) {

    println(startText)


    println (endText)

}

