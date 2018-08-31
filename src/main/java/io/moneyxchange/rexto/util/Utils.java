package io.moneyxchange.rexto.util;

public class Utils {

    public static boolean isStringInArray (String str, String[] arr) {
        if (arr != null) {
            for (String el : arr) {
                if(el.equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void validateExchangeRate(String sourceCurrency, String targetCurrency) throws BadDataException{
        Double rateExchange = null;

        // validating currencies
        if (!isStringInArray(sourceCurrency, CurrencyConstants.ALLOWED_CURRENCIES)) {
            throw new BadDataException("Currently we don't support currency '" + sourceCurrency + "'");
        }

        if (!isStringInArray(targetCurrency, CurrencyConstants.ALLOWED_CURRENCIES)) {
            throw new BadDataException("Currently we don't support currency '" + targetCurrency + "'");
        }
    }
}
