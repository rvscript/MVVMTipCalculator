package com.example.mvvmtipcalculator.viewmodel

import com.example.mvvmtipcalculator.model.Calculator
import com.example.mvvmtipcalculator.model.TipCalculation

class CalculatorViewModel (val calculator: Calculator = Calculator()) {
//    view works with strings for rendering
    var inputCheckAmount = ""
    var inputTipPercentage = ""

//    set a variable for calculation
    var tipCalculation = TipCalculation()

//    adding a function for the floating action button
    fun calculateTip() {

}
}