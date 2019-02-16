package calculator;

import exception.WrongDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Calculator calculator = null;

    private Calculator() {
        System.out.println("Welcome to SimpleCalculator");
        System.out.println("Choose Operation");
    }

    public static Calculator getInstance(){
        if(calculator == null){
            calculator = new Calculator();
            return calculator;
        }else {
            return calculator;
        }
    }

    public Operation askOperation() {

        Operation result;
        while (true) {
            System.out.println("S - START");
            System.out.println("I - INFO");
            System.out.println("E - EXIT");
            try {
                result = Operation.getAllowableOperation(reader.readLine().toUpperCase());
                return result;
            } catch (WrongDataException | IOException | NumberFormatException e) {
                System.out.println("Wrong Input Data \n");
            }
        }
    }

    public int plus(int a, int b){
        return a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int division(int a, int b){
        return a / b ;
    }

    public double plus(double a, double b){
        return a + b;
    }

    public double minus(double a, double b){
        return a - b;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    public double division(double a, double b){
        return a / b;
    }

    public boolean isDigit(String digit){
        try{
            double a = Double.parseDouble(digit);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isInputValid(String a,String b){
        if(isDigit(a) && !isDigit(b) || isDigit(b) && !isDigit(a)){
            return false;
        }else{
            return true;
        }
    }
}
