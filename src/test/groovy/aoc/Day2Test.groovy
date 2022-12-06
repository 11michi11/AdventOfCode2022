package aoc

import spock.lang.Specification

class Day2Test extends Specification {

    def "Part1Test"() {
        given:
        var day = new Day2()

        expect:
        day.part1("two-test") == 15
    }

    def "Part1"() {
        given:
        var day = new Day2()

        when:
        var result = day.part1("two")

        then:
        result != 0
        print(result)
    }

    def "Part2Test"() {
        given:
        var day = new Day2()

        expect:
        day.part2("two-test") == 12
    }

    def "Part2"() {
        given:
        var day = new Day2()

        when:
        var result = day.part2("two")

        then:
        result != 1
        print(result)
    }
}
