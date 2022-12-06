package aoc

import readInputWhole

class Day1 {

    fun part1(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n\n")

        println(parts)

        var max = parts.maxOfOrNull { it.split("\n").filter {line-> line.isNotEmpty() }.sumOf { that -> Integer.parseInt(that) } }

        return max!!
    }

    fun part2(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n\n")

        var max = parts.map {
            it.split("\n").filter {
                    line-> line.isNotEmpty()
            }.sumOf { that -> Integer.parseInt(that) }
        }.sortedDescending()

        println(max)

        return max[0] + max[1] + max[2]
    }
}
