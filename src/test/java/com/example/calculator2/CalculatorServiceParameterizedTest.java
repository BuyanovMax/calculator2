package com.example.calculator2;

import com.example.calculator2.exception.DivisionByZeroException;
import com.example.calculator2.service.CalculatorService;
import com.example.calculator2.service.CalculatorServiceImpl;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParameterizedTest {

    public static final Integer ZERO = 0;
    public static final Integer POSITIVE_NUMBER1 = 50;
    public static final Integer POSITIVE_NUMBER2 = 150;
    public static final Integer NEGATIVE_NUMBER1 = -100;
    public static final Integer NEGATIVE_NUMBER2 = -50;


    private CalculatorService calculatorService;
    @BeforeEach
    public void before() {
        calculatorService = new CalculatorServiceImpl();
    }

    public static Stream<Arguments> PlusTestParams() {
        return Stream.of(Arguments.of(POSITIVE_NUMBER2, NEGATIVE_NUMBER1, POSITIVE_NUMBER2+NEGATIVE_NUMBER1)
                ,Arguments.of(NEGATIVE_NUMBER2,POSITIVE_NUMBER1,NEGATIVE_NUMBER2+POSITIVE_NUMBER1));
    }

    public static Stream<Arguments> MinusTestParams() {
        return Stream.of(Arguments.of(NEGATIVE_NUMBER1, NEGATIVE_NUMBER2, NEGATIVE_NUMBER1-NEGATIVE_NUMBER2)
                ,Arguments.of(POSITIVE_NUMBER1,POSITIVE_NUMBER2,POSITIVE_NUMBER1-POSITIVE_NUMBER2));
    }

    public static Stream<Arguments> MultiplyTestParams() {
        return Stream.of(Arguments.of(NEGATIVE_NUMBER1, POSITIVE_NUMBER1, NEGATIVE_NUMBER1*POSITIVE_NUMBER1)
                ,Arguments.of(POSITIVE_NUMBER1,NEGATIVE_NUMBER1,POSITIVE_NUMBER1*NEGATIVE_NUMBER1));
    }

    public static Stream<Arguments> DivideTestParams() {
        return Stream.of(
                 Arguments.of(POSITIVE_NUMBER2, NEGATIVE_NUMBER1, POSITIVE_NUMBER2/NEGATIVE_NUMBER1)
                ,Arguments.of(POSITIVE_NUMBER1,NEGATIVE_NUMBER1,POSITIVE_NUMBER1/NEGATIVE_NUMBER1));
    }


    public static Stream<Arguments> DivideNegativeTestParams() {
        return Stream.of(
                Arguments.of(POSITIVE_NUMBER2, ZERO),
                Arguments.of(NEGATIVE_NUMBER2,ZERO));
    }

    @ParameterizedTest
    @MethodSource("PlusTestParams")
    public void calcPlusTest(int a,int b,Integer expected) {

        Assertions.assertThat(calculatorService.calcPlus(a, b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MinusTestParams")
    public void calcMinusTest(int a,int b,Integer expected) {

        Assertions.assertThat(calculatorService.calcMinus(a, b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MultiplyTestParams")
    public void calcMultiplyTest(int a,int b,Integer expected) {

        Assertions.assertThat(calculatorService.calcMultiply(a, b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("DivideTestParams")
    public void calcDivideTest(int a,int b,Integer expected) {

        Assertions.assertThat(calculatorService.calcDivide(a, b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("DivideNegativeTestParams")
    public void calcDivideNegativeTest(int a,int b) {

        Assertions.assertThatExceptionOfType(DivisionByZeroException.class)
                .isThrownBy(() -> calculatorService.calcDivide(a, b));
    }
}
