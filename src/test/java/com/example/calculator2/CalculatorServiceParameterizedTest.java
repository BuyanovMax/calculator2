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


    private CalculatorService calculatorService;
    @BeforeEach
    public void before() {
        calculatorService = new CalculatorServiceImpl();
    }

    public static Stream<Arguments> PlusTestParams() {
        return Stream.of(Arguments.of(5, 5, "5+5=10")
                ,Arguments.of(-1,8,"-1+8=7"));
    }

    public static Stream<Arguments> MinusTestParams() {
        return Stream.of(Arguments.of(5, 5, "5-5=0")
                ,Arguments.of(-1,8,"-1-8=-9"));
    }

    public static Stream<Arguments> MultiplyTestParams() {
        return Stream.of(Arguments.of(5, 5, "5*5=25")
                ,Arguments.of(-1,8,"-1*8=-8"));
    }

    public static Stream<Arguments> DivideTestParams() {
        return Stream.of(
                 Arguments.of(5, 5, "5/5=1")
                ,Arguments.of(10,8,"10/8=1"));
    }


    public static Stream<Arguments> DivideNegativeTestParams() {
        return Stream.of(
                Arguments.of(5, 0),
                Arguments.of(-1,0));
    }

    @ParameterizedTest
    @MethodSource("PlusTestParams")
    public void calcPlusTest(int a,int b,String expected) {

        Assertions.assertThat(calculatorService.calcPlus(a, b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MinusTestParams")
    public void calcMinusTest(int a,int b,String expected) {

        Assertions.assertThat(calculatorService.calcMinus(a, b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MultiplyTestParams")
    public void calcMultiplyTest(int a,int b,String expected) {

        Assertions.assertThat(calculatorService.calcMultiply(a, b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("DivideTestParams")
    public void calcDivideTest(int a,int b,String expected) {

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
