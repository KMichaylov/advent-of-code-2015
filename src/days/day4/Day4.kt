package days.day4

import common.Day
import java.math.BigInteger
import java.security.MessageDigest


class Day4 : Day(exampleFile = "src\\days\\day4\\example.txt", inputFile = "src\\days\\day4\\input.txt") {


    init {
        readExample()
        readInput()
    }
    // Taken from the web.
    fun toHex(byteArray: ByteArray): String? {
        val bigInteger = BigInteger(1, byteArray)
        return String.format("%0" + (byteArray.size shl 1) + "X", bigInteger)
    }

    fun md5Attempt(text: String, number: String, n: Int): Boolean {
        val md5 = MessageDigest.getInstance("MD5")
        val attempt: String = text + number
        val hash: String? = toHex(md5.digest(attempt.toByteArray()))
        println(hash)
        return hash?.take(n) == "0".repeat(n)
    }

    public override fun part1() {
        var number: Int = 0
        val example: String = "abcdef"
        val input: String = "bgvyzdsv"
        var attmp = false
        do {
            attmp = md5Attempt(input, number.toString(), 5)
            println(number)
            number++
        } while (!attmp)
        number--
        println("Solution for part 1 is: $number")
    }

    public override fun part2() {
        var number: Int = 0
        val example: String = "abcdef"
        val input: String = "bgvyzdsv"
        var attmp = false
        do {
            attmp = md5Attempt(input, number.toString(), 6)
            println(number)
            number++
        } while (!attmp)

        number--
        println("Solution for part 2 is: $number")
    }
}

fun main() {
    val day4 = Day4()
//    day4.part1()
    day4.part2()
}