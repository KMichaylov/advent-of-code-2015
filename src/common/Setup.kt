package common

import java.io.File

abstract class Day(val day: Int, val file: String) {

    var lines = mutableListOf<String>()

    protected fun readInput(fileName: String) {
        File(fileName).forEachLine { lines.add(it) }
    }

    protected abstract fun part1()

    protected abstract fun part2()

}