package KotlinBasics

/**
 * Задание 5
 * Вывести элементы массива, которые больше своих соседей
 * Первый и последний элементы не рассматриваются
 */
object Task05 {
    private val SAMPLE_ARRAY = intArrayOf(1, 5, 2, 8, 3, 9, 4, 7, 6)

    fun run() {
        Output.printTitle("Задание 5. Элементы больше соседей")
        Output.printDescription(
            "дан массив целых чисел. Программа выводит элементы, которые\n" +
                    "больше и предыдущего, и следующего элемента. Первый и последний\n" +
                    "элементы не рассматриваются. Реализовано тремя способами:\n" +
                    "for, while, forEach."
        )

        val sourceArray = SAMPLE_ARRAY
        Output.printLine("Массив: ${sourceArray.joinToString()}")

        val peaksViaFor = findPeaksViaFor(sourceArray)
        val peaksViaWhile = findPeaksViaWhile(sourceArray)
        val peaksViaForEach = findPeaksViaForEach(sourceArray)

        Output.printResults(
            "Через for" to peaksViaFor,
            "Через while" to peaksViaWhile,
            "Через forEach" to peaksViaForEach
        )
    }

    /** Поиск «пиков» с помощью цикла for. */
    private fun findPeaksViaFor(array: IntArray): List<Int> {
        val peaks = mutableListOf<Int>()
        val firstInnerIndex = 1
        val lastInnerIndex = array.lastIndex - 1

        for (currentIndex in firstInnerIndex..lastInnerIndex) {
            val previousElement = array[currentIndex - 1]
            val currentElement = array[currentIndex]
            val nextElement = array[currentIndex + 1]

            if (currentElement > previousElement && currentElement > nextElement) {
                peaks.add(currentElement)
            }
        }

        return peaks
    }

    /** Поиск «пиков» с помощью цикла while. */
    private fun findPeaksViaWhile(array: IntArray): List<Int> {
        val peaks = mutableListOf<Int>()
        val firstInnerIndex = 1
        val lastInnerIndex = array.lastIndex - 1
        var currentIndex = firstInnerIndex

        while (currentIndex <= lastInnerIndex) {
            val previousElement = array[currentIndex - 1]
            val currentElement = array[currentIndex]
            val nextElement = array[currentIndex + 1]

            if (currentElement > previousElement && currentElement > nextElement) {
                peaks.add(currentElement)
            }

            currentIndex++
        }

        return peaks
    }

    /** Поиск «пиков» с помощью оператора forEach. */
    private fun findPeaksViaForEach(array: IntArray): List<Int> {
        val peaks = mutableListOf<Int>()

        (1 until array.lastIndex).forEach { currentIndex ->
            val previousElement = array[currentIndex - 1]
            val currentElement = array[currentIndex]
            val nextElement = array[currentIndex + 1]

            if (currentElement > previousElement && currentElement > nextElement) {
                peaks.add(currentElement)
            }
        }

        return peaks
    }
}