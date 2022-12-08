package aoc

import readInputWhole

class Day8 {

    fun part1(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        val heightMap = parts.map { it.toCharArray().map { digit -> digit.digitToIntOrNull()!! } }

        var visibleTrees = 0

        for (i in 1..heightMap.size - 2) {
            for (j in 1..heightMap[i].size - 2) {
                var visibleUp = true
                var visibleDown = true
                var visibleLeft = true
                var visibleRight = true
                // Check up
                for (x in i - 1 downTo 0) {
                    if (heightMap[x][j] >= heightMap[i][j]) {
                        visibleUp = false
                        break
                    }
                }
                // Check down
                for (x in i + 1 until heightMap[i].size) {
                    if (heightMap[x][j] >= heightMap[i][j]) {
                        visibleDown = false
                        break
                    }
                }
                // Check left
                for (y in j - 1 downTo 0) {
                    if (heightMap[i][y] >= heightMap[i][j]) {
                        visibleLeft = false
                        break
                    }
                }
                // Check down
                for (y in j + 1 until heightMap[i].size) {
                    if (heightMap[i][y] >= heightMap[i][j]) {
                        visibleRight = false
                        break
                    }
                }

                if (visibleUp || visibleDown || visibleLeft || visibleRight) {
                    visibleTrees++
                }
            }
        }

        visibleTrees += (heightMap.size * 2) + ((heightMap.size - 2) * 2)
        return visibleTrees
    }


    fun part2(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }

        val heightMap = parts.map { it.toCharArray().map { digit -> digit.digitToIntOrNull()!! } }

        val scenicScores = mutableListOf<Int>()

        for (i in 1..heightMap.size - 2) {
            for (j in 1..heightMap[i].size - 2) {
                var scenicScoreUp = 0
                var scenicScoreDown = 0
                var scenicScoreLeft = 0
                var scenicScoreRight = 0

                // Check up
                for (x in i - 1 downTo 0) {
                    scenicScoreUp++
                    if (heightMap[x][j] >= heightMap[i][j]) {
                        break
                    }

                }
                // Check down
                for (x in i + 1 until heightMap[i].size) {
                    scenicScoreDown++
                    if (heightMap[x][j] >= heightMap[i][j]) {
                        break
                    }
                }
                // Check left
                for (y in j - 1 downTo 0) {
                    scenicScoreLeft++
                    if (heightMap[i][y] >= heightMap[i][j]) {
                        break
                    }
                }
                // Check down
                for (y in j + 1 until heightMap[i].size) {
                    scenicScoreRight++
                    if (heightMap[i][y] >= heightMap[i][j]) {
                        break
                    }
                }

                scenicScores.add(scenicScoreUp * scenicScoreDown * scenicScoreLeft * scenicScoreRight)
            }
        }

        return scenicScores.max()
    }
}
