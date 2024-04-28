package AddressBook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {

    private static final String EMAIL_REGEX = "^[a-zA-Z]{4,}[0-9]*@\\w{3,}\\.(com|net|org|edu|gov|co\\.in)$";

    private static final String CITY_REGEX = "^[a-zA-Z]+\\s*[a-zA-Z]+$";

    private static final String STATE_REGEX = "^[a-zA-Z]+\\s*[a-zA-Z]+$";

    private static final String ZIP_REGEX = "^[0-9]{6}$";

    private static final String CONTACT_REGEX = "^[0-9]{10}$";

    public static boolean isValidEmail(String email){
        Pattern p = Pattern.compile(EMAIL_REGEX);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isValidCity(String city){
        Pattern p = Pattern.compile(CITY_REGEX);
        Matcher m = p.matcher(city);
        return m.matches();
    }

    public static boolean isValidState(String state){
        Pattern p = Pattern.compile(STATE_REGEX);
        Matcher m = p.matcher(state);
        return m.matches();
    }

    public static boolean isValidZip(String zip){
        Pattern p = Pattern.compile(ZIP_REGEX);
        Matcher m = p.matcher(zip);
        return m.matches();
    }

    public static boolean isValidContact(String contact){
        Pattern p = Pattern.compile(CONTACT_REGEX);
        Matcher m = p.matcher(contact);
        return m.matches();
    }
}
