package com.example.apikeypractice.util

class SortNumbers {

    fun sortStringDigits(digitAmount:String,digit:String,replaceDigit:String):String{
        var newDigits = digit.filter { !it.isWhitespace() }

        val firstHalf = newDigits.filter { it.toString() == replaceDigit }
        val secondHalf = newDigits.filterNot{it.toString() == replaceDigit }
        var replacedFirstHalf = firstHalf.replace(replaceDigit,"1")


        val officialString = replacedFirstHalf +secondHalf
        if(officialString.length == digitAmount.toInt()){
            return officialString
        }
        return ""

    }
}