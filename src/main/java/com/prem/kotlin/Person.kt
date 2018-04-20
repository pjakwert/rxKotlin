package com.prem.kotlin;

import kotlin.reflect.KProperty

data class Person(val firstname: String, val lastname: String) {

    override fun toString(): String {
        return firstname + " " + lastname
    }

    operator fun getValue(nothing: Nothing?, property: KProperty<*>): String = toString()
}