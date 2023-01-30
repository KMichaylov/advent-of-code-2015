package days.day5

import common.Day


class Day5 : Day(exampleFile = "src\\days\\day5\\example.txt", inputFile = "src\\days\\day5\\input.txt") {
    private val vowels: List<String>
    private val notPermittedStrings: List<String>


    init {
        readExample()
        readInput()
        vowels = listOf<String>("a", "e", "i", "o", "u")
        notPermittedStrings = listOf<String>("ab", "cd", "pq", "xy")
    }

    private fun String.checkDoubleCharacters(): Boolean {
        for (i in 0 until this.length - 1) {
            if (this[i] == this[i + 1])
                return true
        }
        return false
    }

    private fun String.checkNumberOfVowels(): Boolean {
        var count: Int = 0
        for (i in 0 until this.length) {
            val letter: String = this[i].toString()
            if (vowels.contains(letter))
                count++;
        }
        return count >= 3
    }

    private fun String.checkDoesContainNotPermitted(): Boolean {
        for (el in notPermittedStrings) {
            if (this.contains(el))
                return false
        }
        return true
    }

    private fun String.hasOneLetterBetweenTwoRepeatingLetters(): Boolean {
        for (i in 1 until this.length - 1) {
            if (this[i - 1] == this[i + 1])
                return true
        }
        return false
    }

    private fun String.hasPairAppearingTwice(): Boolean {
        for (i in 0 until this.length - 3) {
            for (j in i until this.length - 3) {
                if (this[i] == this[j + 2] && this[i + 1] == this[j + 3])
                    return true
            }
        }
        return false
    }


    public override fun part1() {
        var count: Int = 0

        for (line in linesInput) {
            if (line.checkDoubleCharacters() && line.checkDoesContainNotPermitted() && line.checkNumberOfVowels())
                count++
        }
        println("Solution for part 1 is: $count")
    }

    public override fun part2() {
        var count: Int = 0

        for (line in linesInput) {
            if (line.hasPairAppearingTwice() && line.hasOneLetterBetweenTwoRepeatingLetters())
                count++
        }
        println("Solution for part 2 is: $count")
    }
}

fun main() {
    val day5 = Day5()
//    day5.part1()
    day5.part2()
}