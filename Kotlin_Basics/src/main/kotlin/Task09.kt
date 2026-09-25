package KotlinBasics

import kotlin.math.sqrt

/**
 * Задание 9
 * Класс Vector в трёхмерном пространстве
 */
class Vector(val x: Double, val y: Double, val z: Double) {

    fun length(): Double = sqrt(x * x + y * y + z * z)

    fun dot(other: Vector): Double =
        x * other.x + y * other.y + z * other.z

    infix fun dotInfix(other: Vector): Double = dot(other)

    operator fun times(other: Vector): Double = dot(other)

    override fun toString(): String = "Vector($x, $y, $z)"
}

/** Внешняя функция скалярного произведения */
fun dotProduct(first: Vector, second: Vector): Double =
    first.x * second.x + first.y * second.y + first.z * second.z

object Task09 {
    private val FIRST_VECTOR_COORDS = Triple(1.0, 2.0, 3.0)
    private val SECOND_VECTOR_COORDS = Triple(3.0, 2.0, 1.0)

    fun run() {
        Output.printTitle("Задание 9. Класс Vector")
        Output.printDescription(
            "создаётся класс Vector с координатами x, y, z. Реализованы\n" +
                    "длина вектора, скалярное произведение (метод), инфиксная запись,\n" +
                    "оператор *, а также внешняя функция скалярного произведения"
        )

        val firstVector = Vector(
            FIRST_VECTOR_COORDS.first,
            FIRST_VECTOR_COORDS.second,
            FIRST_VECTOR_COORDS.third
        )

        val secondVector = Vector(
            SECOND_VECTOR_COORDS.first,
            SECOND_VECTOR_COORDS.second,
            SECOND_VECTOR_COORDS.third
        )

        Output.printLines(
            "firstVector  = $firstVector",
            "secondVector = $secondVector"
        )

        Output.printResults(
            "Длина firstVector" to firstVector.length(),
            "Метод dot" to firstVector.dot(secondVector),
            "Инфикс dotInfix" to (firstVector dotInfix secondVector),
            "Оператор *" to (firstVector * secondVector),
            "Внешняя функция" to dotProduct(firstVector, secondVector)
        )
    }
}