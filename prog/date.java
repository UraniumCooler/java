import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class date {
    public static void main(String[] args) {
        System.out.println(datum());
    }

    public static String datum() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd",Locale.ENGLISH).format(LocalDateTime.now());
    }
}