package common

import java.io.File

abstract class Day(val exampleFile: String, val inputFile: String) {

    protected var linesInput = mutableListOf<String>()

    protected var linesExample = mutableListOf<String>()


    protected fun readInput() {
        File(inputFile).forEachLine { linesInput.add(it) }
    }

    protected fun readExample() {
        File(exampleFile).forEachLine { linesExample.add(it) }
    }

    protected abstract fun part1()

    protected abstract fun part2()

}