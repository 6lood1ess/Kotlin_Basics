package KotlinBasics

/**
 * Задание 6
 * Произведение, min и max массива разными способами
 */
object Task06 {
    private val SAMPLE_ARRAY = intArrayOf(3, 1, 7, 2, 5, 4)
    private const val INITIAL_PRODUCT = 1L

    fun run() {
        Output.printTitle("Задание 6. Произведение, min, max массива")
        Output.printDescription(
            "дан массив. Программа находит произведение элементов, а также\n" +
                    "минимальный и максимальный элементы пятью способами: for, while,\n" +
                    "forEach, reduce, min()/max()"
        )

        val sourceArray = SAMPLE_ARRAY
        Output.printLine("Массив: ${sourceArray.joinToString()}")

        printStatsViaFor(sourceArray)
        printStatsViaWhile(sourceArray)
        printStatsViaForEach(sourceArray)
        printProductViaReduce(sourceArray)
        printStatsViaStdlib(sourceArray)
    }

    private fun printStatsViaFor(array: IntArray) {
        var product = INITIAL_PRODUCT
        var minimal = array.first()
        var maximal = array.first()

        for (element in array) {
            product *= element
            if (element < minimal) minimal = element
            if (element > maximal) maximal = element
        }

        Output.printSection("for")
        Output.printResults(
            "  произведение" to product,
            "  min" to minimal,
            "  max" to maximal
        )
    }

    private fun printStatsViaWhile(array: IntArray) {
        var product = INITIAL_PRODUCT
        var minimal = array.first()
        var maximal = array.first()
        var currentIndex = 0

        while (currentIndex < array.size) {
            val element = array[currentIndex]
            product *= element
            if (element < minimal) minimal = element
            if (element > maximal) maximal = element
            currentIndex++
        }

        Output.printSection("while")
        Output.printResults(
            "  произведение" to product,
            "  min" to minimal,
            "  max" to maximal
        )
    }

    private fun printStatsViaForEach(array: IntArray) {
        var product = INITIAL_PRODUCT
        var minimal = Int.MAX_VALUE
        var maximal = Int.MIN_VALUE

        array.forEach { element ->
            product *= element
            if (element < minimal) minimal = element
            if (element > maximal) maximal = element
        }

        Output.printSection("forEach")
        Output.printResults(
            "  произведение" to product,
            "  min" to minimal,
            "  max" to maximal
        )
    }

    private fun printProductViaReduce(array: IntArray) {
        val product = array.fold(INITIAL_PRODUCT) { accumulator, element ->
            accumulator * element
        }

        Output.printSection("reduce")
        Output.printResult("  произведение", product)
    }

    private fun printStatsViaStdlib(array: IntArray) {
        Output.printSection("min()/max()")
        Output.printResults(
            "  min" to array.min(),
            "  max" to array.max()
        )
    }
}