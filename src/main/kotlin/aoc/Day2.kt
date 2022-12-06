package aoc

import readInputWhole
import kotlin.math.min

class Day2 {

    fun part1(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        val result = parts.map { line ->
            var lineParts = line.split(" ")
            var opppenent = OpponentsChoice.fromString(lineParts[0])
            var mine = MyChoice.fromString(lineParts[1])

            var points = 0;

            if(opppenent.value == mine.value) {
                // Draw
                points += 3
            } else if (opppenent == OpponentsChoice.ROCK && mine == MyChoice.PAPER) {
                // I won
                points += 6
            } else if (opppenent == OpponentsChoice.PAPER && mine == MyChoice.SCISSORS) {
                // I won
                points += 6
            } else if (opppenent == OpponentsChoice.SCISSORS && mine == MyChoice.ROCK) {
                // I won
                points += 6
            } else {
                // lost and got nothing
            }

            points += mine.value

            points
        }.sum()

        return result
    }

    fun part2(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        val win = mapOf(
            OpponentsChoice.ROCK to OpponentsChoice.PAPER,
            OpponentsChoice.PAPER to OpponentsChoice.SCISSORS,
            OpponentsChoice.SCISSORS to OpponentsChoice.ROCK,
            )

        val lose = mapOf(
            OpponentsChoice.ROCK to OpponentsChoice.SCISSORS,
            OpponentsChoice.PAPER to OpponentsChoice.ROCK,
            OpponentsChoice.SCISSORS to OpponentsChoice.PAPER,
        )

        val result = parts.map { line ->
            var lineParts = line.split(" ")
            var opppenent = OpponentsChoice.fromString(lineParts[0])

            val strategy = lineParts[1]
            var points = 0;

            when(strategy) {
                "X" -> {
                    // lose
                    points += lose[opppenent]!!.value
                }
                "Y" -> {
                    // draw
                    points += opppenent.value + 3
                }
                "Z" -> {
                    // win
                    points += win[opppenent]!!.value + 6
                }
            }

            points
        }.sum()

        return result
    }




}

enum class OpponentsChoice (val value: Int ) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    companion object {
        fun fromString(line: String): OpponentsChoice  {
            return when (line) {
                "A" -> ROCK
                "B" -> PAPER
                else -> SCISSORS
            }
        }
    }

}

enum class MyChoice (val value: Int ) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    companion object {
        fun fromString(line: String): MyChoice  {
            return when (line) {
                "X" -> ROCK
                "Y" -> PAPER
                else -> SCISSORS
            }
        }
    }

}
