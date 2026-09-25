package KotlinBasics

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    while (true) {
        printMenu()
        val userChoice = readln().trim().toIntOrNull()

        when (userChoice) {
            MENU_TASK_01 -> runTask { Task01.run() }
            MENU_TASK_02 -> runTask { Task02.run() }
            MENU_TASK_03 -> runTask { Task03.run() }
            MENU_TASK_04 -> runTask { Task04.run() }
            MENU_TASK_05 -> runTask { Task05.run() }
            MENU_TASK_06 -> runTask { Task06.run() }
            MENU_TASK_07 -> runTask { Task07.run() }
            MENU_TASK_08 -> runTask { Task08.run() }
            MENU_TASK_09 -> runTask { Task09.run() }
            MENU_TASK_10 -> runTask { Task10.run() }
            MENU_EXIT -> {
                Output.printLine("\n  Выход из программы. До новых встреч!")
                return
            } else -> {
                Output.printLine("\n  Некорректный ввод. Введите число от 0 до 10")
                Output.pause()
            }
        }
    }
}

private const val MENU_TASK_01 = 1
private const val MENU_TASK_02 = 2
private const val MENU_TASK_03 = 3
private const val MENU_TASK_04 = 4
private const val MENU_TASK_05 = 5
private const val MENU_TASK_06 = 6
private const val MENU_TASK_07 = 7
private const val MENU_TASK_08 = 8
private const val MENU_TASK_09 = 9
private const val MENU_TASK_10 = 10
private const val MENU_EXIT = 0

private fun printMenu() {
    Output.printLines(
        "",
        "-".repeat(60),
        "  Задачник по основам Kotlin",
        "-".repeat(60),
        "  1 — Сумма первой и последней цифры числа",
        "  2 — Статистика чисел до нуля",
        "  3 — Игра «Угадай число»",
        "  4 — Первые n простых чисел",
        "  5 — Элементы массива больше соседей",
        "  6 — Произведение, min и max массива",
        "  7 — Квадратное уравнение",
        "  8 — Класс ArrayStats",
        "  9 — Класс Vector",
        " 10 — Класс Vehicle и наследники",
        "  0 — Выход",
        "-".repeat(60)
    )
    print("  Ваш выбор: ")
}

private inline fun runTask(block: () -> Unit) {
    try {
        block()
    } catch (exception: Exception) {
        Output.printLine("\nОшибка: ${exception.message}")
    }

    Output.pause()
}