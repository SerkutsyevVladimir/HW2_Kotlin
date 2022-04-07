package com.example.mobilecalculator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobilecalculator.databinding.FragmentCalculatorKeyboardBinding
import kotlin.reflect.typeOf


class CalculatorKeyboardFragment : Fragment() {

    private var _binding: FragmentCalculatorKeyboardBinding? = null
    private val binding get() = requireNotNull(_binding) { "View was destroyed" }


    val Operations = "(?<=[^-+*/={,])[-+*/=]"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentCalculatorKeyboardBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            fun setTextFields(value: String) {
                textExpression.append(value)
            }



            button0.setOnClickListener { setTextFields("0") }
            button1.setOnClickListener { setTextFields("1") }
            button2.setOnClickListener { setTextFields("2") }
            button3.setOnClickListener { setTextFields("3") }
            button4.setOnClickListener { setTextFields("4") }
            button5.setOnClickListener { setTextFields("5") }
            button6.setOnClickListener { setTextFields("6") }
            button7.setOnClickListener { setTextFields("7") }
            button8.setOnClickListener { setTextFields("8") }
            button9.setOnClickListener { setTextFields("9") }
            buttonDot.setOnClickListener { setTextFields(".") }

            buttonSub.setOnClickListener { setTextFields("-") }
            buttonSum.setOnClickListener { setTextFields("+") }
            buttonDiv.setOnClickListener { setTextFields("/") }
            buttonMul.setOnClickListener { setTextFields("*") }
            buttonDelete.setOnClickListener {
                textExpression.text = ""
                textResult.text = ""
            }
            buttonBack.setOnClickListener {
                textExpression.text.dropLast(1).also { textExpression.text = it }
                textResult.text = ""
            }
            buttonResult.setOnClickListener {
                var parser = Parser()

                    val expressionString = textExpression.text.toString()
                    if (expressionString.isNotEmpty()) {
                        val result = parser.evaluate(expressionString)
                        if (result is String){
                            Toast.makeText(
                                root.context,
                                result,
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                        else {
                            textResult.text = result.toString()
                        }

                    } else {

                        Toast.makeText(
                            root.context,
                            "Please, enter some values",
                            Toast.LENGTH_LONG
                        )
                            .show()

                    }

            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}