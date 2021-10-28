package userdetailsexception;

public class InvalidDetailsException extends Exception {
    public InvalidDetailsException(ExceptionType enteredNull) {
    }

    enum ExceptionType {
        INVALID_NAME,INVALID_EMAIL, INVALID_MOBILENUMBER,INVALID_PASSWORD,ENTERED_NULL
    }

    ExceptionType type;
    public InvalidDetailsException(ExceptionType type, String message){
        super(message);
        this.type = type;
    }
}
