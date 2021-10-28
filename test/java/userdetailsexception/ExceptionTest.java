package userdetailsexception;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {

    @Test
    public void givenFirstName_CheckValidationForFName_ReturnTrue() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateName("Sravanthi");
        } catch (InvalidDetailsException e) {
            Assert.assertEquals(InvalidDetailsException.ExceptionType.INVALID_NAME, e.type);
        }
    }


    @Test
    public void givenFirstLetterSmall_CheckForValidationForLastName_ReturnFalse() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateName("sravanthi");
        }catch (InvalidDetailsException e) {
            Assert.assertEquals(InvalidDetailsException.ExceptionType.INVALID_NAME, e.type);
        }
    }


    @Test
    public void givenEmail_CheckValidation_ReturnTrue() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateEmail("abc.xyz@gmail.com");
        }catch (InvalidDetailsException e) {
            Assert.assertEquals(InvalidDetailsException.ExceptionType.INVALID_EMAIL, e.type);
        }
    }

    @Test
    public void givenEmailWithoutTld_CheckValidation_ReturnFalse() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateEmail("abc.xyz@gmail");
        }catch (InvalidDetailsException e){
            Assert.assertEquals(InvalidDetailsException.ExceptionType.INVALID_EMAIL, e.type);
        }
    }

    @Test
    public void givenMobileNumber_CheckForValidation_ReturnTrue() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateMobileNumber("98 9908229348");
        }catch (InvalidDetailsException e){
            Assert.assertEquals(InvalidDetailsException.ExceptionType.INVALID_MOBILENUMBER, e.type);
        }
    }

    @Test
    public void givenNumberWithoutCC_CheckForValidation_ReturnFalse() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateMobileNumber("9908229348");
        }catch (InvalidDetailsException e){
            Assert.assertEquals(InvalidDetailsException.ExceptionType.INVALID_MOBILENUMBER, e.type);
        }
    }

    @Test
    public void givenPassWordWithoutSpecialSymbol_CheckForValidation_ReturnFalse() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validatePassWord("sravanthi46");
        }catch (InvalidDetailsException e){
            Assert.assertEquals(InvalidDetailsException.ExceptionType.INVALID_PASSWORD, e.type);
        }
    }

    @Test
    public void givenProperPassWord_CheckForValidity_ReturnTrue(){
        UserDetailsException userDetails = new UserDetailsException();
        try{
            userDetails.validatePassWord("Sravanthi@446");
        }catch (InvalidDetailsException e){
            Assert.assertEquals(InvalidDetailsException.ExceptionType.INVALID_PASSWORD, e.type);
        }
    }
}


