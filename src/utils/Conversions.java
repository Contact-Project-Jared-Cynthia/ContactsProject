package utils;
import java.text.DecimalFormat;

public class Conversions {
    DecimalFormat numberFormat = new DecimalFormat("#.##");
    final private double mm = 1;
    final private double cm_mm = mm * 10;
    final private double m_cm = cm_mm * 100;
    final private double km_m = m_cm * 1000;
    final private double in = 1;
    final private double ft_in = in * 12;
    final private double yd_ft = ft_in * 3;
    final private double mile_yd = yd_ft * 1760 ;
    final private double nm = 1;
    private double conversion = 0;

    double mmTo(double mm, String measurement) {
//        double conversion = 0;
        switch (measurement) {
            case "cm" -> conversion = mm / .1;
            case "inch" -> conversion = mm / 25.4;
            case "feet" -> conversion = mm / 304.8;
            case "yard" -> conversion = mm / 914;
            case "meter" -> conversion = mm / 1000;
            case "km" -> conversion = mm / 1e+6;
            case "mile" -> conversion = mm / 1.609e+6;
            case "nm" -> conversion = mm / 1.852e+6;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

    double cmTo(double cm, String measurement) {
//        double conversion = 0;
        switch (measurement) {
            case "mm" -> conversion = cm * 10;
            case "inch" -> conversion = cm / 2.54;
            case "feet" -> conversion = cm / 30.48;
            case "yard" -> conversion = cm / 91.4;
            case "meter" -> conversion = cm / 100.0;
            case "km" -> conversion = cm / 100_000;
            case "mile" -> conversion = cm / 160_900;
            case "nm" -> conversion = cm / 185_200;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

    double inchTo(double inches, String measurement) {
//        double conversion = 0;
        switch (measurement) {
            case "mm" -> conversion = inches * 25.4;
            case "cm" -> conversion = inches * 2.54;
            case "meter" -> conversion = inches / 0.0254;
            case "km" -> conversion = inches / 39_370;
            case "yard" -> conversion = inches / 36;
            case "feet" -> conversion = inches / 12;
            case "mile" -> conversion = inches / 63_360;
            case "nm" -> conversion = inches / 72_910;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

    double footTo(double feet, String measurement) {
//        double conversion = 0;
        switch (measurement) {
            case "mm" -> conversion = feet * 304.8;
            case "cm" -> conversion = feet * 30.48;
            case "inch" -> conversion = feet * 12;
            case "yard" -> conversion = feet / 3;
            case "meter" -> conversion = feet / 3.281;
            case "km" -> conversion = feet / 3281;
            case "mile" -> conversion = feet / 5280;
            case "nm" -> conversion = feet / 6076;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

    double yardTo(double yards, String measurement) {
        switch (measurement) {
            case "mm" -> conversion = yards * 914.4;
            case "cm" -> conversion = yards * 91.44;
            case "inch" -> conversion = yards * 36;
            case "feet" -> conversion = yards * 3;
            case "meter" -> conversion = yards / 1.094;
            case "km" -> conversion = yards / 1094;
            case "mile" -> conversion = yards / 1760;
            case "nm" -> conversion = yards / 2025;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

    double meterTo(double meters, String measurement) {
        switch (measurement) {
            case "mm" -> conversion = meters * 1000;
            case "cm" -> conversion = meters * 100;
            case "inch" -> conversion = meters * 39.37;
            case "feet" -> conversion = meters * 3.281;
            case "yard" -> conversion = meters * 1.094;
            case "km" -> conversion = meters / 1000;
            case "mile" -> conversion = meters / 1609;
            case "nm" -> conversion = meters / 1852;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

    double kilometerTo(double kilometers, String measurement) {
        switch (measurement) {
            case "mm" -> conversion = kilometers * 1e+6;
            case "cm" -> conversion = kilometers * 100_000;
            case "inch" -> conversion = kilometers * 39_370;
            case "feet" -> conversion = kilometers * 3281;
            case "yard" -> conversion = kilometers * 1094;
            case "meter" -> conversion = kilometers * 1000;
            case "mile" -> conversion = kilometers / 1.609;
            case "nm" -> conversion = kilometers / 1.852;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

    double mileTo(double miles, String measurement) {
        switch (measurement) {
            case "mm" -> conversion = miles * 1.609e+6;
            case "cm" -> conversion = miles * 160_900;
            case "inch" -> conversion = miles * 63_360;
            case "feet" -> conversion = miles * 5280;
            case "yard" -> conversion = miles * 1760;
            case "meter" -> conversion = miles * 1609;
            case "km" -> conversion = miles * 1.609;
            case "nm" -> conversion = miles / 1.151;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

    double nauticalMileTo(double nauticalMiles, String measurement) {
        switch (measurement) {
            case "mm" -> conversion = nauticalMiles * 1.852e+6;
            case "cm" -> conversion = nauticalMiles * 185_200;
            case "inch" -> conversion = nauticalMiles * 72_910;
            case "feet" -> conversion = nauticalMiles * 6076;
            case "yard" -> conversion = nauticalMiles * 2025;
            case "meter" -> conversion = nauticalMiles * 1852;
            case "km" -> conversion = nauticalMiles * 1.852;
            case "mile" -> conversion = nauticalMiles * 1.151;
        }
        return Double.parseDouble(numberFormat.format(conversion));
    }

}
