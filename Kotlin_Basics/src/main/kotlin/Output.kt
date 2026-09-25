package KotlinBasics

object Output {
    private const val SEPARATOR_LENGTH = 60
    private const val SEPARATOR = "-"

    private fun separator(): String = SEPARATOR.repeat(SEPARATOR_LENGTH)

    /** Заголовок задания */
    fun printTitle(title: String) = println(
        buildString {
            appendLine()
            appendLine(separator())
            appendLine("  $title")
            appendLine(separator())
        }
    )

    /** Краткое описание задания */
    fun printDescription(description: String) = println(
        "Описание: $description\n" + "-".repeat(SEPARATOR_LENGTH)
    )

    /** Печатает одну строку (или пустую) */
    fun printLine(message: String = "") = println(message)

    /** Печатает несколько строк разом */
    fun printLines(vararg messages: String) = messages.forEach(::println)

    /** Печатает пару "подпись: значение" */
    fun printResult(label: String, value: Any) = println("$label: $value")

    /** Печатает несколько пар "подпись: значение" разом */
    fun printResults(vararg pairs: Pair<String, Any>) =
        pairs.forEach { (label, value) -> println("$label: $value") }

    /** Заголовок подблока */
    fun printSection(name: String) = println("\n[$name]")

    fun printBlank() = println()

    /** Пауза перед возвратом в меню */
    fun pause() {
        print("\n  Нажмите Enter, чтобы вернуться в меню...")
        readln()
    }
}