package aoc

import spock.lang.Specification

class Day5Test extends Specification {

    def "Part1Test"() {
        given:
        var day = new Day5()

        expect:
        day.part1("five-test") == "CMZ"
    }

    def "Part1"() {
        given:
        var day = new Day5()

        when:
        var result = day.part1("five")

        then:
        result != 0
        print(result)
    }

    def "Part2Test"() {
        given:
        var day = new Day5()

        expect:
        day.part2("five-test") == "MCD"
    }

    def "Part2"() {
        given:
        var day = new Day5()

        when:
        var result = day.part2("five")

        then:
        result != 1
        print(result)
    }
}
