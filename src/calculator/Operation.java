package calculator;

import exception.WrongDataException;

public enum  Operation {
    START,
    INFO,
    EXIT;

    public static Operation getAllowableOperation(String i) throws WrongDataException {
        switch (i){
            case "S" : return START;
            case "I" : return INFO;
            case "E" : return EXIT;
            default: throw new WrongDataException();
        }

    }


}
