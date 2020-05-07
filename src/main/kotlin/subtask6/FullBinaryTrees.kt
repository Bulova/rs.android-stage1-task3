package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        if(count == 1) return "[[0]]"
        if(count % 2 == 0) return "[]"
        if(count == 3) return "[0,0,0]"

        generateTrees("0,0,0", 0, count - 3)

        val resultString = listOfTrees.joinToString(separator = ",")
        return "[$resultString]"
    }

    private fun generateTrees(tree: String, currentRootIndex: Int, rest: Int){
        if(rest == 0) {
            listOfTrees.add("[$tree]")
        } else{
            if(tree[currentRootIndex] == '0') {
                generateTrees("$tree,0,0", currentRootIndex + 1, rest - 2)
                generateTrees("$tree,null,null", currentRootIndex + 1, rest)
            } else {
                val next = tree.indexOf('0', currentRootIndex+1)
                if(next!= -1) generateTrees(tree, next, rest)
            }
        }
    }

    private companion object{
        var listOfTrees = ArrayList<String>()
    }
}
