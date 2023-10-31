package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    static Pattern pattern;
    static Matcher matcher;
    static String regex;
    public static boolean validarcnRegex(String validar, String regexx){
        regex = regexx;
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(validar);
        return matcher.matches();
    }
}
