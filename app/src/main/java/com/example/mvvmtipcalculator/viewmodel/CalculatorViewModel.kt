package com.example.mvvmtipcalculator.viewmodel

import android.util.Log
import com.example.mvvmtipcalculator.model.Calculator
import com.example.mvvmtipcalculator.model.TipCalculation

//  create viewmodel then testcase then bind to view
class CalculatorViewModel(val calculator: Calculator = Calculator()) {
    //    view works with strings for rendering
    var inputCheckAmount = ""
    var inputTipPercentage = ""
    val TAG:String = "viewModelclass"
    //    set a variable for calculation
    var tipCalculation = TipCalculation()

    //    adding a function for the floating action button
    fun calculateTip() {
        Log.d(TAG, "calculateTipInvoked")
        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if(checkAmount != null && tipPct != null) {
            tipCalculation = calculator.calculateTip(checkAmount, tipPct)
        }
    }
}