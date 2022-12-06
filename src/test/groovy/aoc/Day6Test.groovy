package aoc

import spock.lang.Specification

class Day6Test extends Specification {

    def "Part1Test"() {
        given:
        var day = new Day6()

        expect:
        day.part1("six-test") == 7
    }

    def "Part1"() {
        given:
        var day = new Day6()

        when:
        var result = day.part1("six")

        then:
        result != 0
        print(result)
    }

    def "Part2Test"() {
        given:
        var day = new Day6()

        expect:
        day.part2("six-test") == 19
    }

    def "Part2"() {
        given:
        var day = new Day6()

        when:
        var result = day.part2("six")

        then:
        result != 1
        print(result)
    }
}
