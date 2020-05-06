package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        if(count == 1) return "[[0]]"
        if(count % 2 == 0) return "[]"
        if(count == 3) return "[0,0,0]"

        return generateAllTrees(count)
    }

    private fun generateAllTrees(count: Int): String{
        throw NotImplementedError("Not implemented")
    }
}
