package KotlinBasics

/**
 * Задание 8
 * Класс с одномерным массивом и методами
 */
class ArrayStats(private val array: IntArray) {

    private companion object {
        const val INITIAL_PRODUCT = 1L
    }

    fun sumPositive(): Int = array.filter { it > 0 }.sum()

    fun product(): Long = array.fold(INITIAL_PRODUCT) { accumulator, element ->
        accumulator * element
    }

    fun average(): Double =
        if (array.isEmpty()) 0.0 else array.average()
}

object Task08 {
    private val SAMPLE_ARRAY = intArrayOf(3, -1, 5, 2, -4, 6)

    fun run() {
        Output.printTitle("Задание 8. Класс ArrayStats")
        Output.printDescription(
            "создаётся класс, который содержит одномерный массив чисел\n" +
                    "(массив передаётся в конструктор). В классе есть методы: сумма\n" +
                    "положительных элементов, произведение элементов и среднее\n" +
                    "арифметическое. Создаётся объект класса, выводятся результаты"
        )

        val sourceArray = SAMPLE_ARRAY
        val stats = ArrayStats(sourceArray)

        Output.printLine("Массив: ${sourceArray.joinToString()}")
        Output.printResults(
            "Сумма положительных" to stats.sumPositive(),
            "Произведение" to stats.product(),
            "Среднее арифметическое" to stats.average()
        )
    }
}