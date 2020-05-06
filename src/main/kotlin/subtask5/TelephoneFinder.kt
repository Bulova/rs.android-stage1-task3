package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        if(number.toInt() < 0) return null

        var result = mutableListOf<String>()

        for(element in number.withIndex()){
            val neighbours : List<String>? = mapOfNeighbours[element.value.toString()] ?: error("")
            if (neighbours != null) {
                for(neighbour in neighbours) {
                    var newNumber = number.replaceRange(element.index..element.index,neighbour)
                    result.add(newNumber)
                }
            }
        }

        return result.toTypedArray()
    }

    private companion object{
        val mapOfNeighbours : Map <String, List<String>> = mapOf(
            Pair("0", arrayListOf("8")),
            Pair("1", arrayListOf("2","4")),
            Pair("2", arrayListOf("1","3","5")),
            Pair("3", arrayListOf("2","6")),
            Pair("4", arrayListOf("1","5","7")),
            Pair("5", arrayListOf("2","4","6","8")),
            Pair("6", arrayListOf("3","5","9")),
            Pair("7", arrayListOf("4","8")),
            Pair("8", arrayListOf("5","7","9","0")),
            Pair("9", arrayListOf("6","8"))
        )
    }
}
