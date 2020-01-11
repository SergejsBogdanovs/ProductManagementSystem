package main;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Utils {

    public static String formatToPercent(BigDecimal discount) {
        NumberFormat percent = NumberFormat.getPercentInstance();
        return percent.format(discount);
    }

    public static boolean isNumeric(String scannerResultForPrice) {
        try {
            double d = Double.parseDouble(scannerResultForPrice);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
