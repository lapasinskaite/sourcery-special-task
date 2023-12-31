import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PalindromeDatesFinder {

    public static void main(String[] args) {

        printBonusDateBetween(2010, 2015);
    }

    public static void printBonusDateBetween(int startYear, int endYear) {
        List<Date> palindromeDates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdfNew = new SimpleDateFormat("yyyy-MM-dd");

        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    try {
                        String dateStr = String.format("%04d%02d%02d", year, month, day);
                        Date date = sdf.parse(dateStr);

                        if (isPalindrome(dateStr)) {
                            palindromeDates.add(date);
                        }
                    } catch (Exception e) {
                        // Invalid date format - ignore and continue
                    }
                }
            }
        }

        for (Date date : palindromeDates) {
            System.out.println(sdfNew.format(date));
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
