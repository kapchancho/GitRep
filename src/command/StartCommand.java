package command;

import calculator.Calculator;
import calculator.Converter;
import exception.WrongDataException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartCommand implements Command {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Converter converter = new Converter();
    private Calculator calculator = Calculator.getInstance();
    private boolean isDigitArabic = false;
    private boolean intOrDouble = false;

    @Override
    public void execute() {
        System.out.println("Let's start");
        System.out.println("Example 1 + 2 or I + II");
        System.out.println("Type back to return");

        String input;
        while (true) {
            try {
                input = reader.readLine();
                if (input.equalsIgnoreCase("back")) {
                    break;
                }
                String[] result = input.split(" ");

                if (result.length != 3) {
                    throw new WrongDataException();
                }
                String number1 = result[0];
                String number2 = result[2];
                String operation = result[1];
                isDigitArabic = converter.isDigitArabic(number1);
                intOrDouble = number1.contains(".") || number2.contains(".");

                if (calculator.isInputValid(number1, number2)) {
                    switch (operation) {
                        case "-":
                            if(isDigitArabic){
                                if (intOrDouble) {
                                    double res = calculator.minus(Double.parseDouble(number1), Double.parseDouble(number2));
                                    System.out.println(res);
                                    break;

                                } else {
                                    int res = calculator.minus(Integer.parseInt(number1), Integer.parseInt(number2));
                                    System.out.println(res);
                                    break;
                                }
                            }else{
                                int res = calculator.minus(converter.convertRomanToArab(number1),converter.convertRomanToArab(number2));
                                System.out.println(converter.convertArabToRoman(res));
                                break;
                            }
                        case "+":
                            if(isDigitArabic){
                                if (intOrDouble) {
                                    double res = calculator.plus(Double.parseDouble(number1), Double.parseDouble(number2));
                                    System.out.println(res);
                                    break;
                                } else {
                                    int res = calculator.plus(Integer.parseInt(number1), Integer.parseInt(number2));
                                    System.out.println(res);
                                    break;
                                }
                            }else{
                                int res = calculator.plus(converter.convertRomanToArab(number1),converter.convertRomanToArab(number2));
                                System.out.println(converter.convertArabToRoman(res));
                                break;
                            }
                        case "*":
                            if(isDigitArabic){
                                if (intOrDouble) {
                                    double res = calculator.multiply(Double.parseDouble(number1), Double.parseDouble(number2));
                                    System.out.println(res);
                                    break;
                                } else {
                                    int res = calculator.multiply(Integer.parseInt(number1), Integer.parseInt(number2));
                                    System.out.println(res);
                                    break;
                                }
                            }else{
                                int res = calculator.multiply(converter.convertRomanToArab(number1),converter.convertRomanToArab(number2));
                                System.out.println(converter.convertArabToRoman(res));
                                break;
                            }
                        case "/":
                            if(isDigitArabic){
                                if (intOrDouble) {
                                    double res = calculator.division(Double.parseDouble(number1), Double.parseDouble(number2));
                                    System.out.println(res);
                                    break;
                                } else {
                                    if(Integer.parseInt(number1)%Integer.parseInt(number2) > 0){
                                        double res = calculator.division((double) Integer.parseInt(number1),(double) Integer.parseInt(number2));
                                        System.out.println(res);
                                        break;
                                    }
                                }
                            }else{
                                int res = calculator.division(converter.convertRomanToArab(number1),converter.convertRomanToArab(number2));
                                System.out.println(converter.convertArabToRoman(res));
                                break;
                            }
                        default:
                             System.out.println("Wrong Input Data");
                             break;
                    }
                } else {
                    throw new WrongDataException();
                }
            } catch (IOException | WrongDataException | ArithmeticException | NumberFormatException e) {
                System.out.println("Wrong Input Data");
                System.out.println("Example 1 + 2 or I + II");
                System.out.println("Type back to return");
            } catch (NullPointerException e){
                System.out.println("Result is out of range");
            }
        }
    }
}
