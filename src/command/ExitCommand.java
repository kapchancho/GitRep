package command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
            System.out.println("EXIT");
            System.out.println("Thanks for using SimpleCalculator");
    }
}