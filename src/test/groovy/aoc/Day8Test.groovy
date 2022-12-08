package aoc

import spock.lang.Specification

class Day8Test extends Specification {

    def "Part1Test"() {
        given:
        var day = new Day8()

        expect:
        day.part1("eight-test") == 21
    }

    def "Part1"() {
        given:
        var day = new Day8()

        when:
        var result = day.part1("eight")

        then:
        result != 0
        print(result)
    }

    def "Part2Test"() {
        given:
        var day = new Day8()

        expect:
        day.part2("eight-test") == 8
    }

    def "Part2"() {
        given:
        var day = new Day8()

        when:
        var result = day.part2("eight")

        then:
        result != 1
        print(result)
    }
}
