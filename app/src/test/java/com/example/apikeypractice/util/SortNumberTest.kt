package com.example.apikeypractice.util

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SortNumberTest {
    lateinit var sortNumberLocgic: SortNumbers

    @Before  // execute before every test case
    fun setup() {
        sortNumberLocgic = SortNumbers()
    }

    @Test
    fun `Check if number removed space and is sorted in right order and equal proper amount`(){
        val correctNum="111363"
        Assert.assertEquals(correctNum, sortNumberLocgic.sortStringDigits("6", "2 3 6 2 3 2", "2"))

    }
    @Test
    fun `check if number is not equal to correct number`(){
        val incorrectNumber ="112363"
        Assert.assertNotEquals(incorrectNumber,sortNumberLocgic.sortStringDigits("6", "2 3 6 2 3 2", "2"))
    }
}