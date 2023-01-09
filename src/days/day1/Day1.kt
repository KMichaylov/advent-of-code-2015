package days.day1

import common.Day

class Day1 : Day(exampleFile = "src\\days\\day1\\example.txt", inputFile = "src\\days\\day1\\input.txt") {

    init {
        readExample()
        readInput()
    }

    public override fun part1() {
        var floor: Int = 0
        for (line in linesInput) {
            for (symbol in line) {
                when (symbol) {
                    '(' -> floor += 1
                    ')' -> floor -= 1
                }
            }

        }
        println("Solution for part 1 is: $floor")
    }

    public override fun part2() {
        var floor: Int = 0
        var position: Int = 1
        for (line in linesInput) {
            for (symbol in line) {
                when (symbol) {
                    '(' -> floor += 1
                    ')' -> floor -= 1
                }
                if (floor == -1) {
                    println("Solution for part 2 is: $position")
                    return
                }
                position++
            }

        }
    }
}

fun main() {
    val day1 = Day1()
    day1.part1()
    day1.part2()
}