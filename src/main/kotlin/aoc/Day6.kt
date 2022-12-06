package aoc

import readInputWhole

class Day6 {

    fun part1(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }
        val line = parts[0]

        for (i in 3 .. line.length) {
            val chars = setOf(line[i-3], line[i-2], line[i-1], line[i])
            if(chars.size == 4) {
                return i +1
            }
        }


        return 1
    }

    fun part2(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        val line = parts[0]

        for (i in 13 .. line.length) {
            val chars = setOf(line[i-13], line[i-12], line[i-11], line[i-10], line[i-9], line[i-8], line[i-7], line[i-6], line[i-5], line[i-4], line[i-3], line[i-2], line[i-1], line[i])
            if(chars.size == 14) {
                return i +1
            }
        }


        return 1
    }
}
