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
    public String calcPlus(Integer num1, Integer num2) {
        if (num1==null||num2==null) {
            throw new NoDataEnteredException("введите данные");
        }
        return num1 + "+" + num2 + "=" + (num1 + num2);
    }
    @Override
    public String calcMinus(Integer num1, Integer num2) {
        if (num1==null||num2==null) {
            throw new NoDataEnteredException("введите данные");
        }
        return num1 + "-" + num2 + "=" + (num1 - num2);
    }
    @Override
    public String calcMultiply(Integer num1, Integer num2) {
        if (num1==null||num2==null) {
            throw new NoDataEnteredException("введите данные");
        }
        return num1 + "*" + num2 + "=" + (num1 * num2);
    }
    @Override
    public String calcDivide(Integer num1, Integer num2) {
        if (num1==null||num2==null) {
            throw new NoDataEnteredException("введите данные");
        }
        if (num2 == 0) {
            throw new DivisionByZeroException("Делить на ноль нельзя");
        }
        return num1 + "/" + num2 + "=" + (num1 / num2);
    }

}
