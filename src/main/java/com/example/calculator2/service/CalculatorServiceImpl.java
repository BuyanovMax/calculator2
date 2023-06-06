package com.example.calculator2.service;

import com.example.calculator2.exception.DivisionByZeroException;
import com.example.calculator2.exception.NoDataEnteredException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calcGreetings() {
        return "Добро пожаловать в калькулятор";
    }
    @Override
    public Integer calcPlus(Integer num1, Integer num2) {
        if (num1==null||num2==null) {
            throw new NoDataEnteredException("введите данные");
        }
        return num1 + num2;
    }
    @Override
    public Integer calcMinus(Integer num1, Integer num2) {
        if (num1==null||num2==null) {
            throw new NoDataEnteredException("введите данные");
        }
        return num1 - num2;
    }
    @Override
    public Integer calcMultiply(Integer num1, Integer num2) {
        if (num1==null||num2==null) {
            throw new NoDataEnteredException("введите данные");
        }
        return num1 * num2;
    }
    @Override
    public Integer calcDivide(Integer num1, Integer num2) {
        if (num1==null||num2==null) {
            throw new NoDataEnteredException("введите данные");
        }
        if (num2 == 0) {
            throw new DivisionByZeroException("Делить на ноль нельзя");
        }
        return num1 / num2;
    }

}
