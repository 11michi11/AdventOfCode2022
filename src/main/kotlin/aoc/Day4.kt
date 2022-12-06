package aoc

import readInputWhole

class Day4 {

    fun part1(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        return parts.count {pair ->
            val (left, right) = pair.split(',').map { getRange(it) }.map { it.toSet() }

            left.union(right).size == left.size || right.union(left).size == right.size
        }
    }

    private fun getRange(range: String): IntRange {
        val (min, max) = range.split('-').map { Integer.parseInt(it) }
        return min .. max
    }

    fun part2(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        return parts.count {pair ->
            val (left, right) = pair.split(',').map { getRange(it) }.map { it.toSet() }

            left.intersect(right).isNotEmpty()
        }
    }
}
