import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src\\test\\resources", "$name.txt").readLines()

fun readInputWhole(name: String) = File("src\\test\\resources", "$name.txt").readText()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

fun String.isLowerCase(): Boolean {
    for (character in this) {
        if (character.isLowerCase()) {
            return true
        }
    }
    return false
}
fun String.countOccurrences(): MutableMap<Char, Int> {
    val charsMap = mutableMapOf<Char, Int>()

    this.forEach{
        charsMap[it] = charsMap.getOrDefault(it, 0) + 1
    }
    return charsMap
}

fun String.countManyOccurrences(): MutableMap<Char, Long> {
    val charsMap = mutableMapOf<Char, Long>()

    this.forEach{
        charsMap[it] = charsMap.getOrDefault(it, 0) + 1
    }
    return charsMap
}

inline fun <reified T> Array<T>.rotate(distance: Int) =
    toList().also { // toList() is a deep copy to avoid changing the original array.
        Collections.rotate(it, distance)
    }.toTypedArray()

fun Long.toBig() : BigInteger = BigInteger.valueOf(this)

fun print2dList(list: List<List<Any>>) {
    println("----------------------")
    list.forEach { line ->
        line.forEach { print(it) }
        println("")
    }
    println("----------------------")
}

fun print2dArray(list: Array<Array<Char>>) {
    println("----------------------")
    list.forEach { line ->
        line.forEach { print("$it ") }
        println("")
    }
    println("----------------------")
}

fun print2dIntArray(list: Array<Array<Int>>) {
    println("----------------------")
    list.forEach { line ->
        line.forEach { print("$it ") }
        println("")
    }
    println("----------------------")
}

fun print2dPairArray(list: Array<Array<Pair<Int, Int>>>) {
    println("----------------------")
    list.forEach { line ->
        line.forEach { print("$it ") }
        println("")
    }
    println("----------------------")
}
