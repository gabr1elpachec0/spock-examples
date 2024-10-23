package br.com.spockexample.test

import org.example.math.Calculator
import org.example.math.exception.DivisionNumberException
import org.example.math.exception.NegativeNumberException
import spock.lang.Rollup
import spock.lang.Specification
import spock.lang.Unroll

@Rollup
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

    def "should subtract two integers then return the correct value"() {
        given:
        int a = 3
        int b = 2

        when:
        def difference = calculator.subtract(a, b)

        then:
        difference == 1
    }

    def "should sum two integers when using expect then return the correct value"() {
        expect:
        calculator.subtract(4, 2) == 2
    }

    def "should multiply two integers then return the correct value"() {
        given:
        def a = 3
        def b = 4

        when:
        def result = calculator.multiply(a, b)

        then:
        result == 12
    }

    def "should divide two integers then return the correct value"() {
        given:
        def a = 4
        def b = 4

        when:
        def result = calculator.divide(a, b)

        then:
        result == 1
    }

    def "should not subtract two integers when the second number is bigger then throw negative number exception"() {
        given:
        int a = 3
        int b = 5

        when:
        calculator.subtract(a, b)

        then:
        thrown(NegativeNumberException)
    }

    def "should not divide two integers when the rest of the division is not zero"() {
        given:
        def a = 4
        def b = 5

        when:
        calculator.divide(a, b)

        then:
        thrown(DivisionNumberException)
    }

    def "should sum two integers then return the correct value"() {
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

    def "should return the biggest value when comparing two integers"(int a, int b, int c) {
        expect:
        calculator.getMaxValue(a, b) == c

        where:
        a ; b ;; c
        1 ; 3 ;; 3
        2 ; 5 ;; 5
    }

    @Unroll
    def "should sum #a and #b then return #c"(int a, int b, int c) {
        expect:
        calculator.sum(a, b) == c

        where:
        a | b || c
        1 | 3 || 4
        2 | 5 || 7
        2 | 6 || 8
        7 | 5 || 12
    }
}
