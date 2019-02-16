package command;

import calculator.Operation;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private static final Map<Operation,Command> allKnownCommandsMap = new HashMap<>();
    static{
        allKnownCommandsMap.put(Operation.START,new StartCommand());
        allKnownCommandsMap.put(Operation.INFO,new InfoCommand());
        allKnownCommandsMap.put(Operation.EXIT,new ExitCommand());
    }
    public static void execute(Operation operation)  {
        if(allKnownCommandsMap.containsKey(operation)){
            allKnownCommandsMap.get(operation).execute();
        }
    }
    private CommandExecutor(){

    }
}
