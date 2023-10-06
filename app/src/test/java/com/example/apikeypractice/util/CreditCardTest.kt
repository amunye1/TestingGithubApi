package com.example.apikeypractice.util

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CreditCardTest {

    lateinit var creditCardLogic: CreditCard

    @Before  // execute before every test case
    fun setup() {
        creditCardLogic = CreditCard()
    }


    // we need to @Test to mark it as runnable
    @Test // can only be used for unit testing the naming
    fun `Check the provider is valid`() {
        val creditCardACME = "1121-4567-7980-2040"
        val creditCardALFA = "1111-4567-7980-2040"
        val creditCardAMEX = "3796-4567-7980-2040"

        assertTrue(creditCardLogic.checkProvider(creditCardACME)) // verify if the output is TRUE
        assertTrue(creditCardLogic.checkProvider(creditCardALFA)) // verify if the output is TRUE
        assertTrue(creditCardLogic.checkProvider(creditCardAMEX)) // verify if the output is TRUE
    }

    @Test
    fun `Check the provider is invalid`() {
        val creditCardACME = "1234-4567-7980-2040"
        val creditCardALFA = "4321-4567-7980-2040"
        val creditCardAMEX = "3456-4567-7980-2040"

        assertFalse(creditCardLogic.checkProvider(creditCardACME)) // verify if the output is FALSE
        assertFalse(creditCardLogic.checkProvider(creditCardALFA)) // verify if the output is FALSE
        assertFalse(creditCardLogic.checkProvider(creditCardAMEX)) // verify if the output is FALSE
    }

    @Test
    fun `Check the date is valid`() {
        val creditCard = "1121-4567-7980-0312"
        val expiryDate = "03/12"

        assertTrue(creditCardLogic.verifyDate(creditCard, expiryDate))
    }

    @Test
    fun `Check the date is invalid`() {
        val creditCard = "1121-4567-7980-0312"
        val expiryDate = "03/13"

        assertFalse(creditCardLogic.verifyDate(creditCard, expiryDate))
    }
    @Test
    fun `Check the credit card is valid`(){
        val creditCardACME = "1121"
        val creditCardALFA = "1111"
        val creditCardAMEX = "3796"
        val expirydate = "0312"
        assertTrue(creditCardLogic.validateCreditCard(creditCardACME,expirydate))
        assertTrue(creditCardLogic.validateCreditCard(creditCardAMEX,expirydate))
        assertTrue(creditCardLogic.validateCreditCard(creditCardALFA,expirydate))
    }

    @Test
    fun `Check the credit card is invalid`(){
        val creditCardACME = "1121"
        val creditCardALFA = "1111"
        val creditCardAMEX = "3796"
        val expirydate = "0313"
        assertFalse(creditCardLogic.validateCreditCard(creditCardACME,expirydate))
        assertFalse(creditCardLogic.validateCreditCard(creditCardAMEX,expirydate))
        assertFalse(creditCardLogic.validateCreditCard(creditCardALFA,expirydate))
    }




}