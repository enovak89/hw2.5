package userIdentificationService;

import userIdentification.UserIdentification;
import userIdentificationExceptions.WrongLoginException;
import userIdentificationExceptions.WrongPasswordException;

public class UserIdentificationService extends UserIdentification {
    public UserIdentificationService(String login, String password, String confirmPassword) {
        super(login, password, confirmPassword);
    }

    public static Boolean userIdentificationCheck(UserIdentificationService user) {
        try {
            if (user.isLoginCorrect() && user.isPasswordCorrect() && user.confirmParolOk()) {
                System.out.println("User identification data is correct");
                return true;
            } else {
                System.out.println("User identification data is not correct");
                return false;
            }
        } catch (WrongLoginException e) {
            System.out.println("Введите логин короче 21 символа");
            return null;
        }
        catch (WrongPasswordException e) {
            System.out.println("Неудачное подтверждение пароля");
            return null;
        }
    }



    public static boolean isStringSuitableForIdentificationData(String s) {
        String regex = "^[\\w]*$";
        if (s.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLoginLengthCorrect() {
        if (getLogin().length() > 20) {
            throw new WrongLoginException();
        } else {
            return true;
        }
    }

    public boolean isLoginCorrect() {
        if (this.isLoginLengthCorrect() && isStringSuitableForIdentificationData(getLogin())) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isPasswordLengthCorrect() {
        if (getPassword().length() < 20) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPasswordCorrect() {
        if (this.isPasswordLengthCorrect() && isStringSuitableForIdentificationData(getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean confirmParolOk() {
        if (getPassword().equals(getConfirmPassword())) {
            return true;
        } else {
            throw new WrongPasswordException();
        }
    }

}
