package br.com.spockexample.test

import org.example.math.SumService
import spock.lang.Specification

class SumTest extends Specification {
    private SumService sumService = new SumService()

    def "should return the correct value"() {
        given: "two integers"
        int a = numberA;
        int b = numberB;

        when: "the sum method is called"
        def sum = sumService.sum(a, b)

        then: "the sum should be the expected result"
        sum == expectedResult

        where:
        numberA | numberB || expectedResult
        1       | 2       || 3
        5       | 7       || 12
    }
}
