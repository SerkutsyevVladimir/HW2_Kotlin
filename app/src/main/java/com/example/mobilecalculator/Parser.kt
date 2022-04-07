package com.example.mobilecalculator

import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Parser {
    val operations = "(?<=[^-+*/={,])[-+*/=]"
    fun evaluate(expressionString: String): Any? {
        var expressionString = expressionString.replace(" ", "").trim()
        val parts = expressionString.split(Regex(operations))
        val leftPartAsString = parts[0]
        val leftAsDouble = leftPartAsString.toDoubleOrNull()
        if (leftAsDouble == null || leftPartAsString.isEmpty()) {
            return "Please enter digits or correct expression"
        }
        val leftNumber =Number(leftAsDouble)
        if (parts.size == 1) {
            return leftNumber
        } else {
            val rightPartAsString = parts[1]
            val rightAsDouble = rightPartAsString.toDoubleOrNull()
            if (rightAsDouble == null || rightPartAsString.isEmpty()) {

                return leftNumber
            }
            val rightNumber = Number(rightAsDouble)
            val regex = operations.toRegex()
            val operation = regex.find(expressionString)
            when (operation!!.value) {
                "+" -> return leftNumber.add(rightNumber)!!
                "-" -> return leftNumber.sub(rightNumber)!!
                "*" -> return leftNumber.mul(rightNumber)!!
                "/" -> {
                    if (rightNumber.value.toInt() == 0) {


                        return "Division by zero"
                    } else
                        return leftNumber.div(rightNumber)!!
                }
                else -> {
                    return "Sometning went wrong"
                }
            }
        }
    }


        }