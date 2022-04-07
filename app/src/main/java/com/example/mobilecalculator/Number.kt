package com.example.mobilecalculator

class Number(doubleValue: Double) {
    var value: Double = doubleValue


    fun add(other: Number): Number? {
        val sum: Double = value + other.value
        return Number(sum)
    }

    fun sub(other: Number): Number? {
        val sub: Double = value - other.value
        return Number(sub)
    }


    fun mul(other: Number): Number? {
        val mul: Double = value * other.value
        return Number(mul)
    }

    fun div(other: Number): Number {
        val div: Double = value / other.value
        return Number(div)

    }

    override fun toString(): String {
        return value.toString()
    }


}