package KotlinBasics

import kotlin.math.sqrt

/**
 * Задание 7
 * Решение квадратного уравнения ax^2 + bx + c = 0
 */
object Task07 {
    private const val TWO_ROOTS = 2
    private const val ONE_ROOT = 1
    private const val NO_ROOTS = 0
    private const val DISCRIMINANT_ZERO = 0.0
    private const val DOUBLE_MULTIPLIER = 2.0
    private const val DISCRIMINANT_FACTOR = 4.0

    fun sqr(value: Double): Double = value * value

    fun discriminant(coefficientA: Double, coefficientB: Double, coefficientC: Double): Double =
        sqr(coefficientB) - DISCRIMINANT_FACTOR * coefficientA * coefficientC

    fun rootsNumber(coefficientA: Double, coefficientB: Double, coefficientC: Double): Int {
        val discriminantValue = discriminant(coefficientA, coefficientB, coefficientC)
        return when {
            discriminantValue > DISCRIMINANT_ZERO -> TWO_ROOTS
            discriminantValue == DISCRIMINANT_ZERO -> ONE_ROOT
            else -> NO_ROOTS
        }
    }

    fun quadraticRoot(coefficientA: Double, coefficientB: Double, coefficientC: Double) {
        val discriminantValue = discriminant(coefficientA, coefficientB, coefficientC)
        val doubleA = DOUBLE_MULTIPLIER * coefficientA

        when (rootsNumber(coefficientA, coefficientB, coefficientC)) {
            TWO_ROOTS -> {
                val firstRoot = (-coefficientB + sqrt(discriminantValue)) / doubleA
                val secondRoot = (-coefficientB - sqrt(discriminantValue)) / doubleA
                Output.printLine("Два корня: x1 = $firstRoot, x2 = $secondRoot")
            }

            ONE_ROOT -> {
                val singleRoot = -coefficientB / doubleA
                Output.printLine("Один корень: x = $singleRoot")
            }

            else -> Output.printLine("Корней нет (D < 0)")
        }
    }

    fun run() {
        Output.printTitle("Задание 7. Квадратное уравнение")
        Output.printDescription(
            "пользователь вводит коэффициенты a, b, c уравнения ax^2 + bx + c = 0.\n" +
                    "Программа вычисляет дискриминант, определяет количество корней\n" +
                    "(через when) и выводит сами корни"
        )

        print("Введите a b c через пробел: ")
        val coefficients = readln().trim().split(Regex("\\s+"))
        val coefficientA = coefficients[0].toDouble()
        val coefficientB = coefficients[1].toDouble()
        val coefficientC = coefficients[2].toDouble()

        Output.printLine("Уравнение: ${coefficientA}x^2 + ${coefficientB}x + ${coefficientC} = 0")
        quadraticRoot(coefficientA, coefficientB, coefficientC)
    }
}