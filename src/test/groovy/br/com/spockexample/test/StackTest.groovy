package br.com.spockexample.test

import spock.lang.Specification

class StackTest extends Specification {
    def stack

    def setup() {
        stack = new Stack()
        assert stack.empty()
    }

    def "pushing an element to a stack"() {
        given:
        def elem = "push me"

        when:
        stack.push(elem)

        then:
        !stack.isEmpty()
        stack.size() == 1
    }
}
