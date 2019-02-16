package command;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("INFO");
        System.out.println("Plus  1 + 2 or I + II");
        System.out.println("Minus  2 - 1 or II - I");
        System.out.println("Multiplication  1 * 2 or I * II");
        System.out.println("Division  2 / 1 or II / Ii \n");
    }
}
