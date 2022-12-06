package aoc

import spock.lang.Specification

class Day1Test extends Specification {

    def "Part1Test"() {
        given:
        var day = new Day1()

        expect:
        day.part1("one-test") == 24000
    }

    def "Part1"() {
        given:
        var day = new Day1()

        when:
        var result = day.part1("one")

        then:
        result != 0
        print(result)
    }

    def "Part2Test"() {
        given:
        var day = new Day1()

        expect:
        day.part2("one-test") == 45000
    }

    def "Part2"() {
        given:
        var day = new Day1()

        when:
        var result = day.part2("one")

        then:
        result != 1
        print(result)
    }
}
