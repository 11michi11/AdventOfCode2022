package aoc

import spock.lang.Specification

class Day4Test extends Specification {

    def "Part1Test"() {
        given:
        var day = new Day4()

        expect:
        day.part1("four-test") == 2
    }

    def "Part1"() {
        given:
        var day = new Day4()

        when:
        var result = day.part1("four")

        then:
        result != 0
        print(result)
    }

    def "Part2Test"() {
        given:
        var day = new Day4()

        expect:
        day.part2("four-test") == 4
    }

    def "Part2"() {
        given:
        var day = new Day4()

        when:
        var result = day.part2("four")

        then:
        result != 1
        print(result)
    }
}
