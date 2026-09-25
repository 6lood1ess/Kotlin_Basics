package KotlinBasics

/**
 * Задание 1
 * Пользователь вводит целое положительное число
 * Вычислить сумму первой и последней цифры
 */
object Task01 {
    private const val DECIMAL_BASE = 10

    fun run() {
        Output.printTitle("Задание 1. Сумма первой и последней цифры")
        Output.printDescription(
            "пользователь вводит целое положительное число.\n" +
                    "Программа вычисляет сумму его первой и последней цифры\n" +
                    "двумя способами: через арифметику и через строки"
        )

        print("Введите целое положительное число: ")
        val userInput = readln().trim()

        val number = userInput.toInt()
        val lastDigit = number % DECIMAL_BASE
        var firstDigit = number
        while (firstDigit >= DECIMAL_BASE) {
            firstDigit /= DECIMAL_BASE
        }
        val sumViaArithmetic = firstDigit + lastDigit
        val sumViaString = userInput.first().digitToInt() +
                userInput.last().digitToInt()

        Output.printResults(
            "Способ 1 (арифметика)" to sumViaArithmetic,
            "Способ 2 (first/last)" to sumViaString
        )
    }
}