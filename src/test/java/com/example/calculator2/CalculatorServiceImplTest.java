package com.example.calculator2;

import com.example.calculator2.exception.DivisionByZeroException;
import com.example.calculator2.service.CalculatorService;
import com.example.calculator2.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class CalculatorServiceImplTest {

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

    @Test
    public void calcPlusTest() {
        var actual = calculatorService.calcPlus(POSITIVE_NUMBER1,NEGATIVE_NUMBER2);
        var expected = POSITIVE_NUMBER1+NEGATIVE_NUMBER2;

        Assertions.assertEquals(expected, actual);


        actual = calculatorService.calcPlus(POSITIVE_NUMBER2,NEGATIVE_NUMBER1);
        expected = POSITIVE_NUMBER2+NEGATIVE_NUMBER1;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void calcMinusTest() {
        var actual = calculatorService.calcMinus(NEGATIVE_NUMBER2,POSITIVE_NUMBER1);
        var expected = NEGATIVE_NUMBER2-POSITIVE_NUMBER1;

        Assertions.assertEquals(expected, actual);


        actual = calculatorService.calcMinus(POSITIVE_NUMBER1,NEGATIVE_NUMBER1);
        expected = POSITIVE_NUMBER1-NEGATIVE_NUMBER1;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void calcMultiplyTest() {
        var actual = calculatorService.calcMultiply(POSITIVE_NUMBER1,POSITIVE_NUMBER2);
        var expected = POSITIVE_NUMBER1*POSITIVE_NUMBER2;

        Assertions.assertEquals(expected, actual);


        actual = calculatorService.calcMultiply(NEGATIVE_NUMBER2,NEGATIVE_NUMBER1);
        expected = NEGATIVE_NUMBER2*NEGATIVE_NUMBER1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcDivideTest() {
        var actual = calculatorService.calcDivide(POSITIVE_NUMBER2,NEGATIVE_NUMBER1);
        var expected = POSITIVE_NUMBER2/NEGATIVE_NUMBER1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcNegativeDivideTest() {
        Assertions.assertThrows(DivisionByZeroException.class, () -> calculatorService.calcDivide(POSITIVE_NUMBER2, ZERO));
        Assertions.assertThrows(DivisionByZeroException.class, () -> calculatorService.calcDivide(POSITIVE_NUMBER1, ZERO));
    }

}
