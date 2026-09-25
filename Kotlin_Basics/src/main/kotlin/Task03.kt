package KotlinBasics

/**
 * Задание 3
 * Программа «Угадай число»
 */
object Task03 {
    private val HIDDEN_NUMBER_RANGE = 0..10

    fun run() {
        Output.printTitle("Задание 3. Угадай число")
        Output.printDescription(
            "программа загадывает случайное число от 0 до 10.\n" +
                    "Пользователь вводит свой вариант. Если он больше — «Много»,\n" +
                    "если меньше — «Мало», а если равен — «Угадал»"
        )

        val hiddenNumber = HIDDEN_NUMBER_RANGE.random()
        /**Output.printLine("(Подсказка для отладки: загадано $hiddenNumber)") */

        while (true) {
            print("Ваш вариант: ")
            val userGuess = readln().trim().toIntOrNull() ?: continue

            when {
                userGuess > hiddenNumber -> Output.printLine("Много")
                userGuess < hiddenNumber -> Output.printLine("Мало")
                else -> {
                    Output.printLine("Угадал")
                    break
                }
            }
        }
    }
}