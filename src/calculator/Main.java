package calculator;

import command.CommandExecutor;

public class Main {

    public static void main(String[] args) {
        Calculator calc = Calculator.getInstance();

        Operation operation;
        do {
            operation = calc.askOperation();
            CommandExecutor.execute(operation);
        }while (!operation.equals(Operation.EXIT));


    }

}
