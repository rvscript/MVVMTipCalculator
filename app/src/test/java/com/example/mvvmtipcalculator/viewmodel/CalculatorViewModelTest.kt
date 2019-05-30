package com.example.mvvmtipcalculator.viewmodel

import com.example.mvvmtipcalculator.model.Calculator
import com.example.mvvmtipcalculator.model.TipCalculation
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class CalculatorViewModelTest {
    //    our testing instance for the class we wish to test
    lateinit var calculatorViewModel: CalculatorViewModel

    @Mock
    lateinit var mockCalculator: Calculator

    //  do this to create an instance of the class you wish to test
    @Before
    fun setup() {
//    MockitoAnnotations setup
        MockitoAnnotations.initMocks(this)
        calculatorViewModel = CalculatorViewModel(mockCalculator)
    }

    //    Create your test cases: this is for every test
//    Create a mock for the calculator view model: use Mockito add in gradle
/*
To use mockito on final classes add mockito dependency to gradle and sync gradle
goto > projects> app> test> create this> (mockito-extensions directory) create this>
 */
    @Test
    fun testCalculateTip() {
        calculatorViewModel.inputCheckAmount = "10.00"
        calculatorViewModel.inputTipPercentage = "15"

//    Mockito stub and and mock
        val stub = TipCalculation(checkAmount = 10.00, tipAmount = 1.5, grandTotal = 11.5)
        `when`(mockCalculator.calculateTip(10.00, 15)).thenReturn(stub)

        calculatorViewModel.calculateTip()

        assertEquals(stub, calculatorViewModel.tipCalculation)
    }

    // validate call to calculate bad tip percentage
    @Test
    fun testCalculateTipBadTipPercentage() {
        calculatorViewModel.inputCheckAmount = "10.00"
        calculatorViewModel.inputTipPercentage = ""

        calculatorViewModel.calculateTip()
//        verify values and if bad never call mock
        verify(mockCalculator, never()).calculateTip(anyDouble(),anyInt())
    }

    // validate call to calculate bad check amount
    @Test
    fun testCalculateTipBadCheckAmount() {
        calculatorViewModel.inputCheckAmount = ""
        calculatorViewModel.inputTipPercentage = "15"

        calculatorViewModel.calculateTip()
//        verify values and if bad never call mock
        verify(mockCalculator, never()).calculateTip(anyDouble(),anyInt())
    }

}