package com.example.apikeypractice.util

/*
* ACME 1121
* ALFA 1111
* AMEX 3796
*
* Two inputs
*
* 1 -> 1121-0000-0000-0312
* 2 -> 03/12 -> Expiry Date
* -> 1121 -> First 4 digit represent company
* -> 0312 -> Last 4 digit represent expiry date
*
* -> Find out if the inputs are a valid card or not?
*
* */


//fun main() {
//
//    val firstInput = "1121-0000-0000-0312"
//    val secondInput = "03/12"
//
////    println(isCardValid(firstInput, secondInput))
//
//}

////////////// Abdullahi  //////////////
fun main() {

    println("This is :" + isCardValid("1121-0000-0000-0312", "03/12"))
    println("This is :" + isCardValid("1122-0000-0000-0312", "03/12"))
    println("This is :" + isCardValid("1121-0000-0000-0313", "03/12"))
    println("This is :" + isCardValid("1121-0000-0000-0312", "03/13"))


}

fun isCardValid(firstInput: String, expDate: String): Boolean {
    val firstFour = firstInput.substring(0, 4)
//    println(firstFour)
    val lastFour = firstInput.substring(15, 19)
//    println(lastFour)
    val ACME = 1121
    val ALFA = 1111
    val AMEX = 3796

    var result = expDate.filter { it.isDigit() }
//    println(result)

    if ((firstFour.equals(ACME.toString()) || firstFour.equals(ALFA.toString()) || firstFour.equals(
            AMEX.toString()
        )) && result.equals(lastFour)
    ) {
        return true
    }
    return false
}

////////////// Abdullahi  //////////////


////////////// Samuel  //////////////

//val test1 = main(1121568798344321, 4321)
//val test2 = main(1129568798344321, 4321)
//val test3 = main(1121568798344321, 4621)
//val test4 = main(9121568798344321, 4121)
//
//
//println(test1)
//println(test2)
//println(test3)
//println(test4)
//
//fun main(creditCardNumber: Any, expiryDate: Any): Boolean {
//    val ACME = "1121"
//    val ALFA = "1111"
//    val AMEX = "3796"
//    val cardNumber = extractNumbers(creditCardNumber.toString())
//    val expireNumber = extractNumbers(expiryDate.toString())
//
//    val cardLength = creditCardNumber.toString().length
//    if (cardLength != 16) {
//        return false
//    }
//
//    val firstFourDigits = cardNumber.substring(0, 4)
//    val lastFourDigits = cardNumber.substring(cardLength-4, cardLength)
//
//    return (firstFourDigits == ACME ||
//            firstFourDigits == ALFA ||
//            firstFourDigits == AMEX) &&
//            lastFourDigits == expireNumber
//}
//
//fun extractNumbers(input: String): String {
//    val regex = Regex("[\\d\\-/]+")
//    val matches = regex.findAll(input)
//
//    val numbers = StringBuilder()
//    for (match in matches) {
//        numbers.append(match.value)
//    }
//    return numbers.toString()
//}


////////////// Samuel  //////////////


////////////// Peter  //////////////

//fun main() {
//    val firstInput = "1234-4567-7980-2040"
//    val secondInput = "03/12"
//
//
//    var firstArray = firstInput.split('-')
//    var secondArray = secondInput.split('/')
//    //println(firstArray)
//
//    val firstFourDigits = firstArray.take(4).joinToString("")
//
////    val lastFourDigits =
//
//    when (firstFourDigits) {
//        "1121" -> println("ACME")
//        "1111" -> println("ALFA")
//        "3796" -> println("AMEX")
//        else -> println("Unknown card type")
//    }
//
//
//}


////////////// Peter  //////////////


