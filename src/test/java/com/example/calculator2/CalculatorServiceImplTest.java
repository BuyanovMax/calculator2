package com.example.calculator2;

import com.example.calculator2.exception.DivisionByZeroException;
import com.example.calculator2.service.CalculatorService;
import com.example.calculator2.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class CalculatorServiceImplTest {

    private CalculatorService calculatorService;
    @BeforeEach
    public void before() {
         calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void calcPlusTest() {
        var actual = calculatorService.calcPlus(5,5);
        var expected = "5+5=10";

        Assertions.assertEquals(expected, actual);


        actual = calculatorService.calcPlus(-2,5);
        expected = "-2+5=3";

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void calcMinusTest() {
        var actual = calculatorService.calcMinus(5,5);
        var expected = "5-5=0";

        Assertions.assertEquals(expected, actual);


        actual = calculatorService.calcMinus(-2,5);
        expected = "-2-5=-7";

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void calcMultiplyTest() {
        var actual = calculatorService.calcMultiply(5,5);
        var expected = "5*5=25";

        Assertions.assertEquals(expected, actual);


        actual = calculatorService.calcMultiply(-2,5);
        expected = "-2*5=-10";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcDivideTest() {
        var actual = calculatorService.calcDivide(5,5);
        var expected = "5/5=1";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcNegativeDivideTest() {
        Assertions.assertThrows(DivisionByZeroException.class, () -> calculatorService.calcDivide(5, 0));
        Assertions.assertThrows(DivisionByZeroException.class, () -> calculatorService.calcDivide(8, 0));
    }

}
