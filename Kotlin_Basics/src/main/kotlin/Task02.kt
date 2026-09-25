package KotlinBasics

/**
 * Задание 2
 * Пользователь вводит числа до тех пор, пока не введёт 0
 * Вывести количество, сумму и среднее арифметическое
 */
object Task02 {
    private const val TERMINATING_VALUE = 0.0

    fun run() {
        Output.printTitle("Задание 2. Статистика до нуля")
        Output.printDescription(
            "пользователь поочерёдно вводит любые числа, подтверждая каждое\n" +
                    "нажатием Enter, пока не введёт 0. После этого программа выводит\n" +
                    "количество введённых чисел, их сумму и среднее арифметическое"
        )

        var enteredCount = 0
        var totalSum = 0.0

        while (true) {
            print("Введите число: ")
            val enteredValue = readln().trim().toDoubleOrNull()

            if (enteredValue == null) {
                Output.printLine("Некорректный ввод, повторите")
                continue
            }

            if (enteredValue == TERMINATING_VALUE) break
            enteredCount++
            totalSum += enteredValue
        }

        val averageValue =
            if (enteredCount > 0) totalSum / enteredCount else 0.0

        Output.printResults(
            "Количество чисел" to enteredCount,
            "Сумма" to totalSum,
            "Среднее арифметическое" to averageValue
        )
    }
}