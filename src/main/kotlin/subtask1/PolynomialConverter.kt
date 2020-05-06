package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {

        if(numbers.isEmpty()){
            return null
        }

        var degree: Int = numbers.size - 1
        var resultString = ""

        for(element in numbers.withIndex()){

            if(element.value != 0) {

                if(element.index != 0){
                    resultString += if(element.value > 0) {
                        " + "
                    } else {
                        " - "
                    }
                }

                resultString += addMultiplier(element.value.absoluteValue, element.index == numbers.size - 1) +
                    addDegree(degree)
            }

            degree--
        }

        return resultString
    }

    private fun addDegree(degree: Int): String{
        return when(degree){
            0 -> ""
            1 -> ""
            else -> "^$degree"
        }
    }

    private fun addMultiplier(multiplier: Int, isLast: Boolean): String{
        return when(multiplier){
            1 -> if(!isLast) "x" else "1"
            else -> if(!isLast) "$multiplier"+"x" else "$multiplier"
        }
    }
}
