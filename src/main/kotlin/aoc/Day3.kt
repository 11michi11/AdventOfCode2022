package aoc

import readInputWhole

class Day3 {

    fun part1(filename: String): Int {
        val input = readInputWhole(filename)
        val rucksacks = input.split("\n").filter { it.isNotEmpty() }

        val result = rucksacks.sumOf { rucksack ->
            val leftHalf = rucksack.substring(0, rucksack.length / 2)
            val rightHalf = rucksack.substring(rucksack.length / 2, rucksack.length)

            val sharedItem = leftHalf.asIterable().intersect(rightHalf.asIterable().toSet()).first()

            val priority = if (sharedItem.isLowerCase()) {
                sharedItem.code - 'a'.code + 1
            } else {
                sharedItem.code - 'A'.code + 27
            }
//            println("$sharedItem $priority")
            priority
        }

        return result
    }

    fun part2(filename: String): Int {
        val input = readInputWhole(filename)
        val rucksacks = input.split("\n").filter { it.isNotEmpty() }

        val result = rucksacks.chunked(3).sumOf { rucksack ->
            val (first, second, third) = rucksack

            val sharedItem = first.asIterable().intersect(second.toSet()).intersect(third.toSet()).first()

            val priority = if (sharedItem.isLowerCase()) {
                sharedItem.code - 'a'.code + 1
            } else {
                sharedItem.code - 'A'.code + 27
            }
//            println("$sharedItem $priority")
            priority
        }

        return result
    }
}
