package userdetailsexception;

import java.util.regex.Pattern;

public class UserDetailsException {

    private final static String FIRST_NAME = "([A-Z][a-zA-Z]{2,})$";
    private final static String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private final static String MOBILE_NUMBER = "^(\\d{2})( )([6-9]{1})(\\d{9})";
    private final static String PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]{1})(?=\\S+$).{8,}";
    private String exception;


    public void validateName(String name) throws InvalidDetailsException {
        this.exception = name;
        validateName();
    }

    public boolean validateName() throws InvalidDetailsException {
        try {
            Pattern pattern = Pattern.compile(FIRST_NAME);
            if (pattern.matcher(exception).matches())
                return true;
            else
                throw new InvalidDetailsException(InvalidDetailsException.ExceptionType.INVALID_NAME,"Please enter valid FirstName");
        } catch (NullPointerException e) {
            throw new InvalidDetailsException(InvalidDetailsException.ExceptionType.ENTERED_NULL,"Enter valid FirstName");
        }
    }

    public boolean validateEmail(String email) throws InvalidDetailsException {
        try {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            if (pattern.matcher(email).matches())
                return true;
            else
                throw new InvalidDetailsException(InvalidDetailsException.ExceptionType.INVALID_EMAIL, "Please enter valid Email");
        }catch (NullPointerException e){
            throw new InvalidDetailsException(InvalidDetailsException.ExceptionType.ENTERED_NULL, "Please enter valid Email");
        }
    }

    public boolean validateMobileNumber(String mobileNumber) throws InvalidDetailsException{
        try {
            Pattern pattern = Pattern.compile(MOBILE_NUMBER);
            if (pattern.matcher(mobileNumber).matches())
                return true;
            else
                throw new InvalidDetailsException(InvalidDetailsException.ExceptionType.INVALID_MOBILENUMBER, "Please enter valid Mobile Number");
        }catch (NullPointerException e){
            throw new InvalidDetailsException(InvalidDetailsException.ExceptionType.ENTERED_NULL, "Please enter valid Mobile Number");
        }
    }

    public boolean validatePassWord(String passWord) throws InvalidDetailsException {
        try {
            Pattern pattern = Pattern.compile(PASSWORD);
            if (pattern.matcher(passWord).matches())
                return true;
            else
                throw new InvalidDetailsException(InvalidDetailsException.ExceptionType.INVALID_PASSWORD, "Please enter valid PassWord");
        } catch (NullPointerException e) {
            throw new InvalidDetailsException(InvalidDetailsException.ExceptionType.ENTERED_NULL, "Please enter valid PassWord");
        }
    }
}
