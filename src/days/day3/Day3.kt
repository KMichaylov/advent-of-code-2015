package days.day3

import common.Day

class Day3 : Day(exampleFile = "src\\days\\day3\\example.txt", inputFile = "src\\days\\day3\\input.txt") {


    init {
        readExample()
        readInput()
    }

    public override fun part1() {
        var numberOfPresents: Int = 1
        var visitedPlaces = mutableListOf<Pair<Int, Int>>(Pair(0, 0))
        var (x, y) = Pair(0, 0)
        for (direction in linesInput[0]) {
            when (direction) {
                '^' -> y += 1
                'v' -> y -= 1
                '>' -> x += 1
                '<' -> x -= 1
            }
            if (Pair(x, y) !in visitedPlaces) {
                visitedPlaces += Pair(x, y)
                numberOfPresents++
            }


        }
        println("Solution for part 1 is: $numberOfPresents")
    }

    public override fun part2() {

        var numberOfHousesWithPresents: Int = 1
        var visitedPlaces = mutableListOf<Pair<Int, Int>>(Pair(0, 0))
        var (x, y) = Pair(0, 0)
        var (x2, y2) = Pair(0, 0)
        var santaTurn: Boolean = true
        for (direction in linesInput[0]) {
            when (direction) {
                '^' -> if (santaTurn) y += 1 else y2 += 1
                'v' -> if (santaTurn) y -= 1 else y2 -= 1
                '>' -> if (santaTurn) x += 1 else x2 += 1
                '<' -> if (santaTurn) x -= 1 else x2 -= 1
            }
            if (Pair(x, y) !in visitedPlaces && santaTurn) {
                visitedPlaces += Pair(x, y)
                numberOfHousesWithPresents++

            }

            if (Pair(x2, y2) !in visitedPlaces && !santaTurn) {
                visitedPlaces += Pair(x2, y2)
                numberOfHousesWithPresents++

            }
            santaTurn = !santaTurn

        }

        println("Solution for part 2 is: $numberOfHousesWithPresents")
    }
}

fun main() {
    val day3 = Day3()
    day3.part1()
    day3.part2()
}