package com.example.apikeypractice.util

class CreditCard {
  //  1) write test cases for validateCreditCard function

//    2) Solve the problem and write test cases for it:

//Three inputs where
//-> Number of digits
//-> Array of digits exactly count of first input separated by space
//-> Digit to replace/sort to start
//Given:
//-> All the inputs will be in String
//-> The Array passed in second in put will be separated by space
//-> All the inputs will be digits
//Requirements:
//-> You replace the number/digit in ARRAY with 1
//-> All the 1s should be at start of the list (Sorted)

//Sample Input:
//6
//2 3 6 2 3 2
//2

    //Expected Output:
//111363
//Steps for example only
//(2 3 6 2 3 2)
//(1 3 6 2 3 2)
//(1 1 3 6 3 2)
//(1 1 1 3 6 3)
    val ACME = 1121
    val ALFA = 1111
    val AMEX = 3796

    fun validateCreditCard(creditCard: String, expiryDate: String): Boolean {
        return checkProvider(creditCard) && verifyDate(creditCard, expiryDate)
    }

    fun verifyDate(creditCard: String, expiryDate: String): Boolean {
        return creditCard.takeLast(4) == expiryDate.replace("/", "")
    }

    fun checkProvider(creditCard: String): Boolean {
        return when (creditCard.take(4)) {
            ACME.toString() -> true
            ALFA.toString() -> true
            AMEX.toString() -> true
            else -> false
        }
    }



}