package com.example.mvvmtipcalculator.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import android.util.Log
import com.example.mvvmtipcalculator.R
import com.example.mvvmtipcalculator.model.Calculator
import com.example.mvvmtipcalculator.model.TipCalculation

//  create viewmodel then testcase then bind to view
private const val TAG: String = "viewModelclass"

class CalculatorViewModel @JvmOverloads constructor(
    val app: Application, val calculator: Calculator = Calculator()
) : ObservableViewModel(app) {
    //    view works with strings for rendering
    var inputCheckAmount = ""
    var inputTipPercentage = ""
    //    set a variable for calculation
//    var tipCalculation = TipCalculation()
//    replace tipCalculation variables with new output variables
    var outputCheckAmount = ""
    var outputTipAmount = ""
    var outputTotalDollarAmount = ""

    //    create an initialization block
    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc: TipCalculation) {
        outputCheckAmount = getApplication<Application>().getString(R.string.dollar_amount, tc.checkAmount)
        outputTipAmount = getApplication<Application>().getString(R.string.dollar_amount, tc.tipAmount)
        outputTotalDollarAmount = getApplication<Application>().getString(R.string.dollar_amount, tc.grandTotal)
    }

    //    adding a function for the floating action button
    fun calculateTip() {
//        Log.d(TAG, "calculateTipInvoked")
        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPct != null) {
//            Log.d(TAG, "CheckAmount: $checkAmount, TipPercentage: $tipPct")
            updateOutputs(calculator.calculateTip(checkAmount, tipPct))
            clearInputs()
        }
    }

    fun clearInputs() {
        inputCheckAmount = "0.00"
        inputTipPercentage = "0"
        notifyChange()
    }
}

