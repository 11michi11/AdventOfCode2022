package aoc

import spock.lang.Specification

class Day7Test extends Specification {

    def "Part1Test"() {
        given:
        var day = new Day7()

        expect:
        day.part1("seven-test") == 95437
    }

    def "Part1"() {
        given:
        var day = new Day7()

        when:
        var result = day.part1("seven")

        then:
        result != 0
        print(result)
    }

    def "Part2Test"() {
        given:
        var day = new Day7()

        expect:
        day.part2("seven-test") == 24933642
    }

    def "Part2"() {
        given:
        var day = new Day7()

        when:
        var result = day.part2("seven")

        then:
        result != 1
        print(result)
    }
}
