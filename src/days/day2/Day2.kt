package days.day2

import common.Day

class Day2 : Day(exampleFile = "src\\days\\day2\\example.txt", inputFile = "src\\days\\day2\\input.txt") {

    init {
        readExample()
        readInput()
    }

    public override fun part1() {
        var sum: Int = 0
        for (line in linesInput) {
            val numbers = line.split('x').map { Integer.parseInt(it) }
            sum += 2 * numbers[0] * numbers[1] + 2 * numbers[1] * numbers[2] + 2 * numbers[0] * numbers[2] + minOf(
                numbers[0] * numbers[1],
                numbers[1] * numbers[2],
                numbers[0] * numbers[2]
            )
        }

        println("Solution for part 1 is: $sum")
    }

    public override fun part2() {
        var sum: Int = 0
        for (line in linesInput) {
            val n = line.split('x').map { Integer.parseInt(it) }
            var numbers = mutableListOf<Int>(n[0], n[1], n[2]).sorted()
            sum += numbers[0] + numbers[0] + numbers[1] + numbers[1] + (numbers[0] * numbers[1] * numbers[2])
        }

        println("Solution for part 2 is: $sum")
    }
}

fun main() {
    val day2 = Day2()
    day2.part1()
    day2.part2()
}