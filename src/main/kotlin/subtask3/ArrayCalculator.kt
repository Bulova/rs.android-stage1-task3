package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var arrayOfIntegers = filterByIntegers(itemsFromArray)
        var maxProduct = 1

        if(arrayOfIntegers.isEmpty()) {
            maxProduct = 0
        } else if(numberOfItems >= arrayOfIntegers.size) {
            maxProduct = calculateMaxProduct(arrayOfIntegers)
        } else{
            var array = ArrayList<Int>(arrayOfIntegers.sortedBy { it.absoluteValue }.reversed())
            maxProduct = calculateMaxProduct(array.subList(0,numberOfItems))
            if(maxProduct < 0) {
                val product1 = calculateMaxProduct(replaceMinNegativeWithMaxPositive(array, numberOfItems))
                val product2 = calculateMaxProduct(replaceMinPositiveWithMaxNegative(array, numberOfItems))

                maxProduct = if(product1 > product2) product1 else product2
            }
        }

        return maxProduct
    }

    private fun filterByIntegers(arr: Array<Any>): ArrayList<Int>{
        var arrayOfIntegers = ArrayList<Int>()

        for(element in arr){
            if(element is Int){
                arrayOfIntegers.add(element)
            }
        }

        return arrayOfIntegers
    }

    private fun calculateMaxProduct(arr: List<Int>): Int{
        var maxProduct = 1

        if(arr.contains(0)) {
            maxProduct = 0
        } else {
            arr.forEach { element -> maxProduct *= element }
        }

        return maxProduct
    }

    private fun replaceMinNegativeWithMaxPositive(list: ArrayList<Int>, numberOfItems: Int): ArrayList<Int>{
        val sublist1 = list.subList(0, numberOfItems)
        val sublist2 = list.subList(numberOfItems,list.size)
        val result = ArrayList<Int>(sublist1)

        var minNegative = 0
        for(element in sublist1){
            if(element < 0 && element < minNegative) minNegative = element
        }

        var maxPositive = 0
        for(element in sublist2){
            if(element > 0 && element > maxPositive) maxPositive = element
        }

        result.remove(minNegative)
        result.add(maxPositive)

        return result
    }

    private fun replaceMinPositiveWithMaxNegative(list: ArrayList<Int>, numberOfItems: Int): ArrayList<Int>{
        val sublist1 = list.subList(0, numberOfItems)
        val sublist2 = list.subList(numberOfItems,list.size-1)
        val result = ArrayList<Int>(sublist1)

        var minPositive = 0
        for(element in sublist1){
            if(element in 1 until minPositive) minPositive = element
        }

        var maxNegative = 0
        for(element in sublist2){
            if(element < 0 && element < maxNegative) maxNegative = element
        }

        result.remove(minPositive)
        result.add(maxNegative)

        return result
    }
}
