package com.example.apikeypractice.util

//1) write test cases for validateCreditCard function

//2) Solve the problem and write test cases for it:

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

fun main(){
    println("This is the number: " + sortStringDigits("6", "2 3 6 2 3 2", "2"))
}

fun sortStringDigits(digitAmount:String,digit:String,replaceDigit:String):String{
    var newDigits = digit.filter { !it.isWhitespace() }
    var replaceDigit = newDigits.replace(replaceDigit,"1")

    val sortedString = replaceDigit.toCharArray().sorted().joinToString("")
    val firstHalf = sortedString.substring(0,4)
    val secondHalf = sortedString.substring(4, 6).toCharArray().sortedDescending().joinToString("")

    val officialString = firstHalf +secondHalf
    if(replaceDigit.length == digitAmount.toInt()){
        return officialString
    }
    return ""

}