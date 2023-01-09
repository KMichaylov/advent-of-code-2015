package common

import java.io.File
import java.io.FileNotFoundException

abstract class Day(val exampleFile: String, val inputFile: String) {

    protected var linesInput = mutableListOf<String>()

    protected var linesExample = mutableListOf<String>()


    protected fun readInput() {
        try {
            File(inputFile).forEachLine { linesInput.add(it) }
        } catch (e: FileNotFoundException) {
            println("The file $inputFile is not found")
        }
    }

    protected fun readExample() {
        try {
            File(exampleFile).forEachLine { linesExample.add(it) }
        } catch (e: FileNotFoundException) {
            println("The file $exampleFile is not found")
        }

    }

    protected abstract fun part1()

    protected abstract fun part2()

}