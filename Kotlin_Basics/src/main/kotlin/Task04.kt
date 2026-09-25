package KotlinBasics

/**
 * Задание 4
 * Вывести n первых простых чисел, начиная с 2
 */
object Task04 {
    private const val FIRST_PRIME = 2

    private fun isPrime(candidate: Int): Boolean {
        if (candidate < FIRST_PRIME) return false

        var divisor = FIRST_PRIME
        while (divisor * divisor <= candidate) {
            if (candidate % divisor == 0) return false
            divisor++
        }

        return true
    }

    fun run() {
        Output.printTitle("Задание 4. Первые n простых чисел")
        Output.printDescription(
            "пользователь задаёт количество n (n >= 1). Программа выводит\n" +
                    "первые n простых чисел, начиная с 2, с указанием порядкового номера"
        )

        print("Введите количество простых чисел n: ")
        val requestedCount = readln().trim().toInt()

        var foundCount = 0
        var candidate = FIRST_PRIME
        while (foundCount < requestedCount) {
            if (isPrime(candidate)) {
                foundCount++
                Output.printLine("$foundCount-ое число: $candidate")
            }

            candidate++
        }
    }
}