package aoc

import spock.lang.Specification

class Day3Test extends Specification {

    def "Part1Test"() {
        given:
        var day = new Day3()

        expect:
        day.part1("three-test") == 157
    }

    def "Part1"() {
        given:
        var day = new Day3()

        when:
        var result = day.part1("three")

        then:
        result != 0
        print(result)
    }

    def "Part2Test"() {
        given:
        var day = new Day3()

        expect:
        day.part2("three-test") == 70
    }

    def "Part2"() {
        given:
        var day = new Day3()

        when:
        var result = day.part2("three")

        then:
        result != 1
        print(result)
    }
}
