package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        if(array[0] == array[1]) return 1
        if(array[0] < array[1]) return null
        else {
            var k = 1

            do {
                if(k!=array[1]) k++
                else return null
            } while(calculateCombinations(array[1], k) < array[0])

            return k
        }
    }

    private fun calculateCombinations(n: Int, k: Int): Int{
       return (calculateFactorial(n)/(calculateFactorial(n-k)*calculateFactorial(k))).toInt()
    }

    private fun calculateFactorial(n: Int): Long{
        var factorial: Long = 1
        for (i in 1..n) {
            factorial *= i.toLong()
        }

        return factorial
    }
}
