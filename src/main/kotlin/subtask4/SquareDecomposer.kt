package subtask4

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decompose(number * number, number - 1)
    }

    private fun decompose(decomposedValue: Int, firstElement: Int): Array<Int>? {

        for(x in firstElement downTo 1) {
            val rest = decomposedValue - x * x

            if(rest < 0) return null
            if(rest == 0) return arrayOf(x)

            var sqrt = sqrt(rest.toDouble()).toInt()
            if(sqrt >= x) sqrt = x - 1

            val result = decompose(rest, sqrt)

            if (result != null) return result + arrayOf(x)
        }

        return null
    }
}
