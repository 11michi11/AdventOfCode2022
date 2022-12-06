package aoc

import readInputWhole
import kotlin.collections.ArrayDeque

class Day5 {

    fun part1(filename: String): String {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        // Parsing stupid input

        val numberOfStacks = parts.first { it.startsWith(" 1") }.split("   ").map { it.trim() }.size
        val stacks = Array<ArrayDeque<Char>>(numberOfStacks) { ArrayDeque() }
        val inputStacks = parts.takeWhile { !it.startsWith(" 1") }

        inputStacks.forEach{line ->
            val chunks = line.chunked(4)
            chunks.forEachIndexed { index, element ->
                if(element.trim().isNotEmpty()) {
                    stacks[index].addLast(element.trim()[1])
                }
            }
        }

        // Parsing and applying operations

        val operations = parts.filter { it.startsWith("move") }

        operations.forEach { operationLine ->
            val operationLineParts = operationLine.split(" ")
            val amount = operationLineParts[1].toInt()
            val source = operationLineParts[3].toInt() - 1
            val destination = operationLineParts[5].toInt() - 1

            repeat(amount) {
                stacks[destination].addFirst(stacks[source].removeFirst())
            }
        }

        var result = ""
        stacks.forEach { stack -> result += stack.first() }



        return result
    }

    fun part2(filename: String): String {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        // Parsing stupid input

        val numberOfStacks = parts.first { it.startsWith(" 1") }.split("   ").map { it.trim() }.size
        val stacks = Array<ArrayDeque<Char>>(numberOfStacks) { ArrayDeque() }
        val inputStacks = parts.takeWhile { !it.startsWith(" 1") }

        inputStacks.forEach{line ->
            val chunks = line.chunked(4)
            chunks.forEachIndexed { index, element ->
                if(element.trim().isNotEmpty()) {
                    stacks[index].addLast(element.trim()[1])
                }
            }
        }

        // Parsing and applying operations

        val operations = parts.filter { it.startsWith("move") }

        operations.forEach { operationLine ->
            val operationLineParts = operationLine.split(" ")
            val amount = operationLineParts[1].toInt()
            val source = operationLineParts[3].toInt() - 1
            val destination = operationLineParts[5].toInt() - 1

            val tempStack = ArrayDeque<Char>()

            repeat(amount) {
                tempStack.addLast(stacks[source].removeFirst())
            }

            repeat(amount) {
                stacks[destination].addFirst(tempStack.removeLast())
            }


        }

        var result = ""
        stacks.forEach { stack -> result += stack.first() }



        return result
    }
}
