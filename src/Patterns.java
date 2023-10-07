import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Patterns {
    public final static String PATTERN = "[\\w]{5,20}+";
    public static void main(String[] args) {
        try {
            registration("David", "germani", "germani");
        } catch (WrongLoginException | WrongPasswordException e ) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean registration (String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches(PATTERN)) {
                throw new WrongLoginException("Не верный логин");
            }
        if (!password.matches(PATTERN)) {
            throw new WrongPasswordException("Ошибка пароля");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        return true;
    }
}
