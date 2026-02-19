package p2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public abstract class j {
    private static String a(int v) {
        switch(v) {
            case 0: {
                return "EEEE, MMMM d, yyyy";
            }
            case 1: {
                return "MMMM d, yyyy";
            }
            case 2: {
                return "MMM d, yyyy";
            }
            case 3: {
                return "M/d/yy";
            }
            default: {
                throw new IllegalArgumentException("Unknown DateFormat style: " + v);
            }
        }
    }

    private static String b(int v) {
        switch(v) {
            case 0: 
            case 1: {
                return "h:mm:ss a z";
            }
            case 2: {
                return "h:mm:ss a";
            }
            case 3: {
                return "h:mm a";
            }
            default: {
                throw new IllegalArgumentException("Unknown DateFormat style: " + v);
            }
        }
    }

    public static DateFormat c(int v, int v1) {
        return new SimpleDateFormat(j.a(v) + " " + j.b(v1), Locale.US);
    }
}

