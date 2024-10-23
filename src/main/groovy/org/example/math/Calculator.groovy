package org.example.math

import groovy.transform.Canonical
import org.example.math.exception.DivisionNumberException
import org.example.math.exception.NegativeNumberException

@Canonical
class Calculator {
    int sum(int a, int b) {
        return a + b
    }

    int subtract(int a, int b) {
        if (b > a) {
            throw new NegativeNumberException("O segundo número é maior que o primeiro")
        }
        return a - b
    }

    int multiply(int a, int b) {
        return a * b
    }

    int divide(int a, int b) {
        if (a % b != 0) {
            throw new DivisionNumberException("Divisão com resto diferente de zero");
        }
        return a / b
    }

    int getMaxValue(int a, int b) {
        if (a > b) {
            return a
        } else {
            return b
        }
    }
}
