package com.example.apikeypractice.util

class SortNumbers {

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
}