package com.johndcoding.lemonadeshop.core.util;


public class CheckFormatUtil {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String DECIMAL_PATTERN = "(\\d+)((,|\\.)(\\d+))?";

    private CheckFormatUtil(){

    }


    /**
     * Verifie que la chaine @param str est un email valide.
     * @param str: chaine a tester
     * @return true si la chaine est un email valide ou null.
     */
    public static boolean isEmail(String str){
        boolean result = true;
        if(str != null){
            result = str.matches(EMAIL_PATTERN);
        }
        return result;
    }

    /**
     * Verifie que la chaine @param str est un nombre entier ou a virgule valide.
     * @param str: chaine a tester
     * @return true si la chaine est un nombre entier ou a virgule ou null.
     */
    public static boolean isDecimalNumber(String str){
        boolean result = true;
        if(str != null){
            result = str.matches(DECIMAL_PATTERN);
        }
        return result;
    }

}
