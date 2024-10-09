package br.com.spockexample.test

import spock.lang.Specification

class StackTest extends Specification {
    def "should push item to stack"() {
        given:
        def stack = new Stack()
        def elem = "elem"

        when:
        stack.push(elem)

        then:
        !stack.isEmpty()
    }
}
