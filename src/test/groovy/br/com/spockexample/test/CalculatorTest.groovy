package br.com.spockexample.test

import org.example.math.Calculator
import spock.lang.Specification

class CalculatorTest extends Specification {
    def calculator

    def setup() {
        calculator = new Calculator()
    }

    def "should sum two integers then return the correct value"() {
        given:
        int a = 3
        int b = 4

        when:
        def sum = calculator.sum(a, b)

        then:
        sum == 7
    }

    def "should sum #a and #b then return the correct value"() {
        when:
        def sum = calculator.sum(a, b)

        then:
        sum == expectedResult

        where:
        a  | b  || expectedResult
        3  | 4  || 7
        5  | 6  || 11
        10 | 21 || 31
    }
}
