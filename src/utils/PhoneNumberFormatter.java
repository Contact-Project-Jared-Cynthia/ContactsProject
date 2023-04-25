package utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberFormatter{
    public String phoneNumberFormatter(String phone_number){
        String phoneNumberRegex = """
                                  (?:(?<countryCode>\\d{1,2})[-.,\\s]?)?
                                  (?:\\(?(?<areaCode>\\d{3})\\)?[-.,\\s]?)?
                                  (?:(?<exchange>\\d{3})[-.,\\s]?)
                                  (?<lineNumber>\\d{4})
                                  """;

        Pattern pat = Pattern.compile(phoneNumberRegex, Pattern.COMMENTS);
        Matcher mat = pat.matcher(phone_number);
        if (mat.matches()){
            switch (phone_number.length()){
                case 11 -> phone_number = String.format("""
                                                        %s (%s) %s - %s
                                                        """, mat.group("countryCode"), mat.group("areaCode"), mat.group("exchange"), mat.group("lineNumber"));
                case 10 -> phone_number = String.format("""
                                                        (%s) %s - %s
                                                         """, mat.group("areaCode"), mat.group("exchange"), mat.group("lineNumber"));
                case 7 -> phone_number = String.format("""
                                                       %s - %s
                                                       """, mat.group("exchange"), mat.group("lineNumber"));
            }
        }

        return phone_number;
    }
}

