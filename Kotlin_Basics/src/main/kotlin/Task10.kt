package KotlinBasics

/**
 * Задание 10
 * Суперкласс Vehicle и три наследника
 */
open class Vehicle(
    open val name: String = "Транспорт",
    open val speed: Int = 0
) {
    open fun start() {
        Output.printLine("$name начал движение со скоростью $speed км/ч")
    }

    open fun stop() {
        Output.printLine("$name остановился")
    }
}

class Boat(
    override val name: String = "Лодка",
    override val speed: Int = 30
) : Vehicle(name, speed) {
    override fun start() {
        Output.printLine("Лодка начала движение со скоростью $speed км/ч")
    }

    override fun stop() {
        Output.printLine("Лодка бросила якорь")
    }
}

class Airplane(
    override val name: String = "Самолёт",
    override val speed: Int = 900
) : Vehicle(name, speed) {
    override fun start() {
        Output.printLine("Самолёт начал движение со скоростью $speed км/ч")
    }

    override fun stop() {
        Output.printLine("Самолёт совершил посадку")
    }
}

class Tank(
    override val name: String = "Танк",
    override val speed: Int = 50
) : Vehicle(name, speed) {
    override fun start() {
        Output.printLine("Танк начал движение со скоростью $speed км/ч")
    }

    override fun stop() {
        Output.printLine("Танк остановился")
    }
}

object Task10 {
    private val VEHICLES: List<Vehicle> = listOf(Boat(), Airplane(), Tank())

    fun run() {
        Output.printTitle("Задание 10. Vehicle и наследники")
        Output.printDescription(
            "создаётся суперкласс Vehicle с двумя свойствами (название, скорость)\n" +
                    "и двумя методами (start, stop). Три класса-наследника — Boat,\n" +
                    "Airplane, Tank — переопределяют их. Демонстрируется полиморфизм"
        )

        for (vehicle in VEHICLES) {
            vehicle.start()
            vehicle.stop()
            Output.printBlank()
        }
    }
}