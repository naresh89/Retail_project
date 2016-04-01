package oracle.retail.apps.aipdt.common.model.util;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

import oracle.adf.share.logging.ADFLogger;

import oracle.retail.apps.aipdt.common.Constants;

public class StringUtil {
    private static ADFLogger logger = ADFLogger.createADFLogger(StringUtil.class);

    public StringUtil() {
        super();
    }

    private static Locale locale = Locale.getDefault();

    
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else {
            return isNullOrEmpty(obj.toString());
        }
    }
    
    /****************************************************************************************************
     * Returns true if the text string is null or empty, false if it contains something.
     * <p>
     * @param text The text.
     * @return True if the text was null or empty, false otherwise.
     ***************************************************************************************************/
    public static boolean isNullOrEmpty(String text) {
        if (text == null || Constants.EMPTY.equals(text.trim())) {
            return true;
        }
        return false;
    }

    /****************************************************************************************************
     * Trims a string, returning null if the input string is already null and an empty string if the
     * string is empty.
     * <p>
     * @param text The text.
     * @return The trimmed text.
     ***************************************************************************************************/
    public static String trim(String text) {
        if (text == null) {
            return null;
        }
        return text.trim();
    }

    /****************************************************************************************************
     * Convert the text string to upper case using the rules of the locale. Returns empty strings for
     * null text values as default.
     * <p>
     * @param text The string to convert.
     * @return The converted string or null.
     ***************************************************************************************************/
    public static String toUpperCase(String text) {
        return toUpperCase(text, false);
    }

    /****************************************************************************************************
     * Convert the text string to upper case using the rules of the locale.
     * <p>
     * @param text The string to convert.
     * @param returnNull True if a null string should return null, false returns empty string.
     * @return The converted string, null, or empty string depending on the parameters.
     ***************************************************************************************************/
    public static String toUpperCase(String text, boolean returnNull) {
        if (text != null) {
            return text.toUpperCase(locale);
        } else if (returnNull) {
            return null;
        }
        return Constants.EMPTY;
    }

    /****************************************************************************************************
     * Covert the text string to lower case using the rules of the locale. Returns empty strings for null
     * text values as default.
     * <p>
     * @param text The string to convert.
     * @return The converted string or null.
     ***************************************************************************************************/
    public static String toLowerCase(String text) {
        return toLowerCase(text, false);
    }

    /****************************************************************************************************
     * Convert the text string to lower case using the rules of the locale.
     * <p>
     * @param text The string to convert.
     * @param returnNull True if a null string should return null, false returns empty string.
     * @return The converted string, null, or empty string depending on the parameters.
     ***************************************************************************************************/
    public static String toLowerCase(String text, boolean returnNull) {
        if (text != null) {
            return text.toLowerCase(locale);
        } else if (returnNull) {
            return null;
        }
        return Constants.EMPTY;
    }

    /****************************************************************************************************
     * Return true if the text represents only numeric digits.
     * <p>
     * @param text The string to validate.
     * @return True if the string is numeric, false otherwise.
     ***************************************************************************************************/
    public static boolean isPureNumeric(String text) {
        if (isNullOrEmpty(text)) {
            return false;
        }
        char[] charArray = text.toCharArray();
        if (charArray.length == 1) {
            return Character.isDigit(charArray[0]);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isDigit(charArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method will return the List value from String value.
     * @param valueStr
     * @param delimiter
     * @return ArrayList
     */
    public static ArrayList<String> getListFromString(String valueStr, String delimiter) {
        ArrayList<String> valueList = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(valueStr, delimiter);
        while (st.hasMoreTokens()) {
            valueList.add(st.nextToken());
        }
        return valueList;
    }

    /**
     * This method will return the Set value from String value.
     * @param valueStr
     * @param delimiter
     * @return HashSet
     */
    public static Set<String> getSetFromString(String valueStr, String delimiter) {
        Set<String> valueList = new HashSet<String>();
        StringTokenizer st = new StringTokenizer(valueStr, delimiter);
        while (st.hasMoreTokens()) {
            valueList.add(st.nextToken());
        }
        return valueList;
    }

    /**
     * This method will return the String value from list value.
     * @param list
     * @param delimiter
     * @return String
     */
    public static String getStringFromList(List<?> list, String delimiter) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            //Collections.sort(selectedNewList);
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    sb.append(list.get(i).toString());

                } else {
                    sb.append(delimiter);
                    sb.append(list.get(i).toString());
                }
            }
        }
        return sb.toString();
    }

    /**
     * This method will return the String value from set value.
     * @param set
     * @param delimiter
     * @return String
     */
    public static String getStringFromSet(Set<?> set, String delimiter) {
        StringBuilder sb = new StringBuilder();
        if (set != null) {
            Iterator<?> itr = set.iterator();
            for (int i = 0; itr.hasNext(); i++) {
                if (i == 0) {
                    sb.append(itr.next().toString());

                } else {
                    sb.append(delimiter);
                    sb.append(itr.next().toString());
                }
            }
        }
        return sb.toString();
    }

    /**
     * This method will return the Oracle Jbo Number from String value.
     * @param value
     * @return numValue
     */
    public static oracle.jbo.domain.Number getJboNumberFromString(String value) {
        oracle.jbo.domain.Number numValue = null;
        try {
            numValue = new oracle.jbo.domain.Number(value);
        } catch (Exception e) {
            logger.severe(e);
        }
        return numValue;
    }

    /**
     * This method will return the BigDecimal from String value.
     * @param value
     * @return numValue
     */
    public static BigDecimal getBigDecimalFromString(String value) {
        BigDecimal numValue = null;
        try {
            numValue = new BigDecimal(value);
        } catch (Exception e) {
            logger.severe(e);
        }
        return numValue;
    }

    /**
     * Breaks the string by the given delimiter into tokens and
     * Builds list with the string tokens with each token enclosed in single quotes
     * @param inputStr
     * @return
     */
    public static List<String> getListFromStringWithQuotes(String inputStr, String delimiter) {
        String inputValues[] = inputStr.split("\\" + delimiter);
        int inputSize = inputValues.length;
        List<String> valueList = new ArrayList<String>(inputSize);
        for (int index = 0; index < inputSize; index++) {
            valueList.add("'" + inputValues[index].trim() + "'");
        }
        return valueList;
    }

    /**
     * This method will return the boolean value based on String value.
     * @param booleanStr
     * @return Boolean
     */
    public static Boolean getBooleanFromString(String booleanStr) {
        Boolean valueStr = null;
        switch (booleanStr.toUpperCase()) {
        case "F":
            valueStr = Boolean.FALSE;
            break;
        case "T":
            valueStr = Boolean.TRUE;
            break;
        case "FALSE":
            valueStr = Boolean.FALSE;
            break;
        case "TRUE":
            valueStr = Boolean.TRUE;
            break;
        case "N":
            valueStr = Boolean.FALSE;
            break;
        case "Y":
            valueStr = Boolean.TRUE;
            break;
        default:
            valueStr = Boolean.FALSE;
            break;
        }
        return valueStr;
    }

    /**
     * This method will return the disable boolean value based on String value.
     * @param booleanStr
     * @return Boolean
     */
    public static Boolean getDisableBooleanFromString(String booleanStr) {
        Boolean valueStr = null;
        switch (booleanStr.toUpperCase()) {
        case "F":
            valueStr = Boolean.TRUE;
            break;
        case "T":
            valueStr = Boolean.FALSE;
            break;
        case "FALSE":
            valueStr = Boolean.TRUE;
            break;
        case "TRUE":
            valueStr = Boolean.FALSE;
            break;
        default:
            valueStr = Boolean.TRUE;
            break;
        }
        return valueStr;
    }

}
